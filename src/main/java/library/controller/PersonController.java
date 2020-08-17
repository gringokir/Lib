package library.controller;

import library.dto.PersonDto;
import library.entity.Person;
import library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<PersonDto> getAll(){
        return personService.getAll();
    }

    @PostMapping
    @RequestMapping("/create")
    public PersonDto createPerson(PersonDto personDto){
        return personService.createPerson(personDto);
    }

    @PutMapping
    @RequestMapping("/update/")
    public PersonDto updatePerson(PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
