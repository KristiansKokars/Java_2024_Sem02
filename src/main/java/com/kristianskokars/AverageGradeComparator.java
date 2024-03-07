package com.kristianskokars;

import com.kristianskokars.model.Grade;
import com.kristianskokars.model.Student;
import com.kristianskokars.service.GradeService;

import java.util.Comparator;
import java.util.List;

public class AverageGradeComparator implements Comparator<Student> {
    private List<Grade> grades;

    public AverageGradeComparator(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public int compare(Student o1, Student o2) {
        double student1AverageGrade;
        double student2AverageGrade;

        try {
            student1AverageGrade = GradeService.getAverageGradeForStudent(o1, grades);
        } catch (Exception e) {
            return -1;
        }

        try {
            student2AverageGrade = GradeService.getAverageGradeForStudent(o2, grades);
        } catch (Exception e) {
            return 1;
        }

        return Double.compare(student1AverageGrade, student2AverageGrade);
    }
}
