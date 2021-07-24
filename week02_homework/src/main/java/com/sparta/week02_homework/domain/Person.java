package com.sparta.week02_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(PersonRequestDto personRequestDto) {
        this(personRequestDto.getName(), personRequestDto.getAge());
    }

    public void update(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
    }
}
