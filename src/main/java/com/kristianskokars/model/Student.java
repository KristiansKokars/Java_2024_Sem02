package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Student {
    private static long idCounter = 1000;

    private Long id;
    private String name;
    private String surname;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !NameValidator.isValidLatvianName(name)) {
            this.name = "---";
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || !NameValidator.isValidLatvianName(surname)) {
            this.name = "---";
        } else {
            this.surname = surname;
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
