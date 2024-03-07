package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Professor extends Person {
    private static long idCounter = 0;

    private Long id;
    private Degree degree;

    public Professor() {
        generateId();
        setName("Janis");
        setSurname("Berzins");
        setDegree(Degree.OTHER);
    }

    public Professor(String name, String surname, Degree degree) {
        generateId();
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }

    public Long getId() {
        return id;
    }

    public void generateId() {
        id = idCounter;
        idCounter++;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        if (degree != null) {
            this.degree = degree;
        } else {
            this.degree = Degree.OTHER;
        }
    }

    @Override
    public String toString() {
        return id + ":" + degree + " " + getName() + " " + getSurname() + " ";
    }
}
