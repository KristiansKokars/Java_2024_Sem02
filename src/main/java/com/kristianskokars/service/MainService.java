package com.kristianskokars.service;

import com.kristianskokars.model.*;

public class MainService {
    public static void main(String[] args) {
        Professor pr1 = new Professor();
        Professor pr2 = new Professor("Karina", "Šķirmante", Degree.MG);

        System.out.println(pr1);
        System.out.println(pr2);

        Student st1 = new Student();
        Student st2 = new Student("Kristiāns", "Kokars");

        System.out.println(st1);
        System.out.println(st2);

        Course c1 = new Course();
        Course c2 = new Course("Data Struktūras un pamatalgoritmi", 4, pr2);

        System.out.println(c1);
        System.out.println(c2);

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(10, st2, c2);

        System.out.println(gr1);
        System.out.println(gr2);
    }
}