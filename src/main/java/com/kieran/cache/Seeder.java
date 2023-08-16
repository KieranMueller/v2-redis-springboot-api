package com.kieran.cache;

import com.kieran.cache.entity.Person;
import com.kieran.cache.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        var person1 = new Person(null, "kieran", "test");
        var person2 = new Person(null, "luke", "pass");
        var person3 = new Person(null, "gaara", "tuna");
        var person4 = new Person(null, "leo", "hockey");
        var person5 = new Person(null, "ryan", "roadtrip");
        var person6 = new Person(null, "reid", "berzerk");
        var person7 = new Person(null, "skeeter", "joe");
        var person8 = new Person(null, "jack", "911");
        var person9 = new Person(null, "nimbus", "cloud");
        var person10 = new Person(null, "frank", "egg");
        var person11 = new Person(null, "jim", "halp");
        var person12 = new Person(null, "dwight", "paper");
        personRepository.saveAll(List.of(person1, person2, person3, person4, person5,
                person6, person7, person8, person9, person10, person11, person12));
    }
}
