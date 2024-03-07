package com.kristianskokars.service;

import com.kristianskokars.model.*;

import java.util.ArrayList;
import java.util.List;

public class MainService {
    public static ArrayList<Professor> allProfessors = new ArrayList<>();
    public static ArrayList<Student> allStudents = new ArrayList<>();
    public static ArrayList<Course> allCourses = new ArrayList<>();
    public static ArrayList<Grade> allGrades = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Professor pr1 = new Professor();
        Professor pr2 = new Professor("Karina", "Šķirmante", Degree.MG);

        allProfessors.add(pr1);
        allProfessors.add(pr2);

//        printList(allProfessors);

        Student st1 = new Student();
        Student st2 = new Student("Kristiāns", "Kokars");
        allStudents.add(st1);

        allStudents.add(st2);

//        printList(allStudents);

        Course c1 = new Course();
        Course c2 = new Course("Data Struktūras un pamatalgoritmi", 2, pr2);

        allCourses.add(c1);
        allCourses.add(c2);

        Grade gr1 = new Grade(6, st1, c1);
        Grade gr2 = new Grade(10, st2, c2);
        Grade gr3 = new Grade(10, st2, c1);

        allGrades.add(gr1);
        allGrades.add(gr2);
        allGrades.add(gr3);

        printList(allGrades);

        GradeService.sortStudentsByAverageGrade(allStudents, allGrades);
        printList(allStudents);

        ArrayList<Person> mixedList = new ArrayList<>();
        mixedList.add(st1);
        mixedList.add(pr1);
        mixedList.add(st2);
        mixedList.add(pr2);
        printList(mixedList);
    }

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
}