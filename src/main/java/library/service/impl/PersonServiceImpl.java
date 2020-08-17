package library.service.impl;

import library.converter.CustomConversionService;
import library.dto.PersonDto;
import library.entity.Person;
import library.exception.PersonException;
import library.repository.PersonRepository;
import library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CustomConversionService conversionService) {
        this.personRepository = personRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonException("Person is not found"));
        return conversionService.convert(person, PersonDto.class);
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        return personList
                .stream()
                .map(person -> conversionService.convert(person, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        return conversionService.convert(personRepository.save(person), PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getPersonId()).orElseThrow(() -> new PersonException("Person is not found"));
        return conversionService.convert(person, PersonDto.class);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonException("Person is not found"));
        personRepository.delete(person);
    }
}
