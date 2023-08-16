package com.kieran.cache.service.impl;

import com.kieran.cache.entity.Person;
import com.kieran.cache.repository.PersonRepository;
import com.kieran.cache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        var foundPerson = personRepository.findById(id).orElseThrow();
        if(person.getName() != null)
            foundPerson.setName(person.getName());
        if(person.getPassword() != null)
            foundPerson.setPassword(person.getPassword());
        return personRepository.save(foundPerson);
    }

    @Override
    public Person deletePerson(Long id) {
        var person = personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
        return person;
    }
}
