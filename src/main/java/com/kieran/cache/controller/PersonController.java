package com.kieran.cache.controller;

import com.kieran.cache.entity.Person;
import com.kieran.cache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("people")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getAll() throws InterruptedException {
        return personService.getAll();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    public Person deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}
