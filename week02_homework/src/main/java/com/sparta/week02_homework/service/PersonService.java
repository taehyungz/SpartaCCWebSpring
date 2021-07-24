package com.sparta.week02_homework.service;

import com.sparta.week02_homework.domain.Person;
import com.sparta.week02_homework.domain.PersonRequestDto;
import com.sparta.week02_homework.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public Long createPerson(PersonRequestDto personRequestDto) {
        Person person = new Person(personRequestDto);
        personRepository.save(person);
        return person.getId();
    }

    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    public Long updatePersonInfo(Long id, PersonRequestDto personRequestDto) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        person.update(personRequestDto);
        return person.getId();
    }

    public Long deletePerson(Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
