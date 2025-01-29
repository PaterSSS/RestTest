package com.restfullAppLesson.restTest.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
@Setter
public class Dog {

    @Id
    private UUID id;

    @Indexed(unique=true)
    private String name;

    private Integer age;
}
