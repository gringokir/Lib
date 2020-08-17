package library.controller;

import library.dto.AddressDto;
import library.dto.PersonDto;
import library.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AddressDto getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<AddressDto> getAll(){
        return addressService.getAll();
    }

    @PostMapping
    @RequestMapping("/create")
    public AddressDto createAddress(AddressDto addressDto){
        return addressService.createAddress(addressDto);
    }

    @PutMapping
    @RequestMapping("/update/")
    public AddressDto updateAddress(AddressDto addressDto) {
        return addressService.updateAddress(addressDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
    }
}
