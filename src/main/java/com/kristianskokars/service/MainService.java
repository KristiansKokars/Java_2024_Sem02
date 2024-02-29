package com.kristianskokars.service;

import com.kristianskokars.model.Degree;
import com.kristianskokars.model.Professor;

public class MainService {
    public static void main(String[] args) {
        Professor pr1 = new Professor();
        Professor pr2 = new Professor("Karina", "Šķirmante", Degree.MG);

        System.out.println(pr1);
        System.out.println(pr2);
    }
}