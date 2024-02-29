package com.kristianskokars.model;

import com.kristianskokars.validator.NameValidator;

public class Course {
    private static long idCounter = 10000;
    private static final int CREDIT_POINT_MAX = 20;

    private Long id;
    private String title;
    private int creditPoints;
    private Professor professor;

    public Course() {
        generateId();
        setTitle("Programmēšana Tīmeklī JAVA");
        setCreditPoints(4);
        setProfessor(new Professor());
    }

    public Course(String title, int creditPoints, Professor professor) {
        generateId();
        setTitle(title);
        setCreditPoints(creditPoints);
        setProfessor(professor);
    }

    public void generateId() {
        id = idCounter;
        idCounter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (NameValidator.isValidLatvianWord(title)) {
            this.title = title;
        } else {
            this.title = "undefined";
        }
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        if (creditPoints < 1 || creditPoints > CREDIT_POINT_MAX) {
            this.creditPoints = 2;
        } else {
            this.creditPoints = creditPoints;
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            this.professor = new Professor();
        } else {
            this.professor = professor;
        }
    }

    @Override
    public String toString() {
        return id + ": " + title + "(" + creditPoints + " KP)," + professor;
    }
}
