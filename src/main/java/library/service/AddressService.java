package library.service;

import library.dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    AddressDto getAddressById(Long id);

    List<AddressDto> getAll();

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(AddressDto addressDto);

    void deleteAddress(Long id);
}
