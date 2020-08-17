package library.service;

import library.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    PersonDto getPersonById(Long id);

    List<PersonDto> getAll();

    PersonDto createPerson(PersonDto personDto);

    PersonDto updatePerson(PersonDto personDto);

    void deletePerson(Long id);
}
