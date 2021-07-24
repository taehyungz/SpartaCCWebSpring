package com.sparta.week02_homework.controller;

import com.sparta.week02_homework.domain.Person;
import com.sparta.week02_homework.domain.PersonRequestDto;
import com.sparta.week02_homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/")
    public List<Person> getPersonList() {
        return personService.findAllPeople();
    }

    @PostMapping("/")
    public Long createPerson(@RequestBody PersonRequestDto personRequestDto) {
        return personService.createPerson(personRequestDto);
    }

    @PutMapping("/{id}")
    public Long changePersonInfo(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto) {
        personService.updatePersonInfo(id, personRequestDto);
        return id;
    }

    @DeleteMapping("/{id}")
    public Long deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}
