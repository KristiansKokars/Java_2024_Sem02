package com.kristianskokars.model;

public class Professor {
    private static long idCounter = 0;

    private Long id;
    private String name;
    private String surname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.matches("[A-Z][a-z]+[A-Z][a-z]+?")) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null && name.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
            this.surname = surname;
        }
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        // I do not like setting any value when you do null
        if (degree == null) return;

        this.degree = degree;
    }

    @Override
    public String toString() {
        return id + ":" + degree + " " + name + " " + surname + " ";
    }
}
