package com.kieran.cache.controller;

import com.kieran.cache.entity.Person;
import com.kieran.cache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Thread.sleep;

@RestController
@RequiredArgsConstructor
@EnableCaching
@CacheConfig(cacheNames={"people"})
@RequestMapping("people")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @Cacheable
    public List<Person> getAll() throws InterruptedException {
        sleep(3000);
        return personService.getAll();
    }

    @GetMapping("{id}")
    @Cacheable
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping
    @CacheEvict(value = "people", allEntries = true)
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("{id}")
    @CacheEvict(value = "people", allEntries = true)
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "people", allEntries = true)
    public Person deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}
