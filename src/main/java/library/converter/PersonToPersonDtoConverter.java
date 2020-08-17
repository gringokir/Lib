package library.converter;


import library.dto.AddressDto;
import library.dto.BookDto;
import library.dto.PersonDto;
import library.dto.PurchaseDto;
import library.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter implements Converter<Person, PersonDto> {
    private final CustomConversionService conversionService;
    private final PersonTypeDtoConverter personTypeDtoConverter;

    @Autowired
    public PersonToPersonDtoConverter(CustomConversionService conversionService, PersonTypeDtoConverter personTypeDtoConverter) {
        this.conversionService = conversionService;
        this.personTypeDtoConverter = personTypeDtoConverter;
    }

    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setPersonId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPurchase(conversionService.convert(person.getPurchase(), PurchaseDto.class));
        personDto.setAddress(conversionService.convert(person.getAddress(), AddressDto.class));
        personDto.setObtainedBooks(conversionService.convert(person.getObtainedBooks(), BookDto.class));
        personDto.setPersonType(personTypeDtoConverter.convertToEntityAttribute(person.getPersonType().ordinal()));
        return personDto;
    }
}
