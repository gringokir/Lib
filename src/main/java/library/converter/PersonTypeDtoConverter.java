package library.converter;

import library.dto.PersonTypeDto;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class PersonTypeDtoConverter implements AttributeConverter<PersonTypeDto, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PersonTypeDto personType) {
        return personType.ordinal();
    }

    @Override
    public PersonTypeDto convertToEntityAttribute(Integer integer) {
        return PersonTypeDto.values()[integer];
    }
}
