package library.converter;

import library.dto.PersonDto;
import library.entity.Address;
import library.entity.Book;
import library.entity.Person;
import library.entity.Purchase;
import library.entity.Storage;
import library.enums.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {
    private final CustomConversionService conversionService;

    @Autowired
    public PersonDtoToPersonConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Person convert(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getPersonId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPurchase(conversionService.convert(personDto.getPurchase(), Purchase.class));
        person.setAddress(conversionService.convert(personDto.getAddress(), Address.class));
        person.setObtainedBooks(conversionService.convert(personDto.getObtainedBooks(), Book.class));
        //person.setPersonType(conversionService.convert(personDto.getPersonType(), PersonType.class));
        return person;
    }
}
