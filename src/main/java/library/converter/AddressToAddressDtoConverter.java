package library.converter;

import library.dto.AddressDto;
import library.dto.PersonDto;
import library.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressDtoConverter implements Converter<Address, AddressDto> {

    @Override
    public AddressDto convert(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouse(address.getHouse());
        addressDto.setFlat(address.getFlat());
        return addressDto;
    }
}
