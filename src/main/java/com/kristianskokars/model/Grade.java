package com.kristianskokars.model;

public class Grade {
    private static long idCounter = 100000;

    private Long id;
    private int value;
    private Student student;
    private Course course;

    public void generateId() {
        id = idCounter;
        idCounter++;
    }

    public Grade() {
        generateId();
        setValue(1);
        setStudent(new Student());
        setCourse(new Course());
    }

    public Grade(int value, Student student, Course course) {
        generateId();
        setValue(value);
        setStudent(student);
        setCourse(course);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 1 || value > 10) {
            value = 1;
        } else {
            this.value = value;
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            this.student = new Student();
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        } else {
            this.course = new Course();
        }
    }

    @Override
    public String toString() {
        return student.getName() + " " + student.getSurname() + " got a " + value + " in " + course.getTitle();
    }
}
