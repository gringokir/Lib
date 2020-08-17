package library.converter;

import library.dto.AddressDto;
import library.entity.Address;
import library.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToAddressConverter implements Converter<AddressDto, Address> {

    @Override
    public Address convert(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getAddressId());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setFlat(addressDto.getFlat());
        return address;
    }
}
