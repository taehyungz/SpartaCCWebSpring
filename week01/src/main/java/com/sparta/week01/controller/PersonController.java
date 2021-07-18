package com.sparta.week01.controller;

import com.sparta.week01.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("길동");
        person.setAge(24);
        person.setAddress("아파트");
        person.setJob("학생");
        return person;
    }
}
