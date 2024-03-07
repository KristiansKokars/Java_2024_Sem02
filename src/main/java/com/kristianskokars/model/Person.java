package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Person {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && NameValidator.isValidLatvianName(name)) {
            this.name = name;
        } else {
            this.name = "---";
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null && NameValidator.isValidLatvianName(surname)) {
            this.surname = surname;
        } else {
            this.surname = "---";
        }
    }
}
