package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Student extends Person {
    private static long idCounter = 1000;
    private Long id;

    public Student() {
        generateId();
        setName("Pēteris");
        setSurname("Liepa");
    }

    public Student(String name, String surname) {
        generateId();
        setName(name);
        setSurname(surname);
    }

    public void generateId() {
        id = idCounter;
        idCounter++;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + getName() + " " + getSurname();
    }
}
