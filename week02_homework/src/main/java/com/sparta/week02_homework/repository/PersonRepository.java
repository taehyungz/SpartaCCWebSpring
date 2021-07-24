package com.sparta.week02_homework.repository;

import com.sparta.week02_homework.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
