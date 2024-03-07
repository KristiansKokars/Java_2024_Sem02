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
        try {
            var student1AverageGrade = GradeService.getAverageGradeForStudent(o1, grades);
            var student2AverageGrade = GradeService.getAverageGradeForStudent(o2, grades);

            return Double.compare(student1AverageGrade, student2AverageGrade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
