package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Student {
    private static long idCounter = 1000;

    private Long id;
    private String name;
    private String surname;

    public void generateId() {
        id = idCounter;
        idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !NameValidator.isValidLatvianName(name)) return;

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || !NameValidator.isValidLatvianName(surname)) return;

        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
