package com.kieran.cache.service;

import com.kieran.cache.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person getById(Long id);

    Person addPerson(Person person);

    Person updatePerson(Long id, Person person);

    Person deletePerson(Long id);
}
