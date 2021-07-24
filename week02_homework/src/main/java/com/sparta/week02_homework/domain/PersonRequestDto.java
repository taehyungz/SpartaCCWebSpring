package com.sparta.week02_homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PersonRequestDto {

    private String name;
    private Integer age;
}
