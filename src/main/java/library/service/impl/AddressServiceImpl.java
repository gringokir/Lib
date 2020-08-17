package library.service.impl;

import library.converter.CustomConversionService;
import library.dto.AddressDto;
import library.entity.Address;
import library.exception.AddressException;
import library.repository.AddressRepository;
import library.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, CustomConversionService conversionService) {
        this.addressRepository = addressRepository;
        this.conversionService = conversionService;
    }

    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressException("Address is not found"));
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList
                .stream()
                .map(address -> conversionService.convert(address, AddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = conversionService.convert(addressDto, Address.class);
        return conversionService.convert(addressRepository.save(address), AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = addressRepository.findById(addressDto.getAddressId()).orElseThrow(() -> new AddressException("Address is not found"));
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressException("Address is not found"));
        addressRepository.delete(address);
    }
}
