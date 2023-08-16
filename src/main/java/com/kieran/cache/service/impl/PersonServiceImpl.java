package com.kieran.cache.service.impl;

import com.kieran.cache.entity.Person;
import com.kieran.cache.repository.PersonRepository;
import com.kieran.cache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    @Cacheable(value = "people")
    public List<Person> getAll() throws InterruptedException {
        sleep(2000);
        logger.info("In getAll()");
        return personRepository.findAll();
    }

    @Override
    @Cacheable(value = "people", key = "#id")
    public Person getById(Long id) throws InterruptedException {
        sleep(2000);
        logger.info("In getById(" + id + ")");
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    @CacheEvict(value = "people", allEntries = true)
    public Person addPerson(Person person) {
        logger.info("Added " + person.getName());
        return personRepository.save(person);
    }

    @Override
    @CacheEvict(value = "people", key = "#id", allEntries = true)
    public Person updatePerson(Long id, Person person) {
        var foundPerson = personRepository.findById(id).orElseThrow();
        logger.info("Updated " + foundPerson.getName());
        if (person.getName() != null)
            foundPerson.setName(person.getName());
        if (person.getPassword() != null)
            foundPerson.setPassword(person.getPassword());
        return personRepository.save(foundPerson);
    }

    @Override
    @CacheEvict(value = "people", key = "#id", allEntries = true)
    public Person deletePerson(Long id) {
        var person = personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
        logger.info("Deleted " + person.getName());
        return person;
    }
}
