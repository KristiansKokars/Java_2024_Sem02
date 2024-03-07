package com.kristianskokars.service;

import com.kristianskokars.AverageGradeComparator;
import com.kristianskokars.model.Course;
import com.kristianskokars.model.Grade;
import com.kristianskokars.model.Professor;
import com.kristianskokars.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradeService {
    public static double getAverageGradeForStudent(Student student, List<Grade> grades) throws Exception {
        List<Grade> studentGrades = grades
                .stream()
                .filter((grade) -> grade.getStudent().equals(student))
                .toList();

        if (studentGrades.isEmpty()) throw new Exception("No grades for student: " + student);

        int gradeSum = 0;
        for (var grade: studentGrades) {
            gradeSum += grade.getValue();
        }

        return gradeSum / studentGrades.size();
    }

    public static double getAverageWeightedGradeForStudent(Student student, ArrayList<Grade> grades) throws Exception {
        List<Grade> studentGrades = grades
                .stream()
                .filter((grade) -> grade.getStudent().equals(student))
                .toList();

        if (studentGrades.isEmpty()) throw new Exception("No grades for student: " + student);

        int gradeSum = 0;
        int kpSum = 0;
        for (var grade: studentGrades) {
            var creditPoints = grade.getCourse().getCreditPoints();
            gradeSum += grade.getValue() * creditPoints;
            kpSum += creditPoints;
        }

        return gradeSum / kpSum;
    }

    public static double getAverageGradeForCourse(Course course, ArrayList<Grade> grades) throws Exception {
        List<Grade> courseGrades = grades
                .stream()
                .filter((grade) -> grade.getCourse().equals(course))
                .toList();

        if (courseGrades.isEmpty()) throw new Exception("No grades for course: " + course);

        int gradeSum = 0;
        for (var grade: courseGrades) {
            gradeSum += grade.getValue();
        }

        return gradeSum / courseGrades.size();
    }

    public static double getProfessorCourseCount(Professor professor, ArrayList<Course> courses) {
        List<Course> professorCourses = courses
                .stream()
                .filter((course) -> course.getProfessor().equals(professor))
                .toList();

        return professorCourses.size();
    }

    public static List<Student> sortStudentsByAverageGrade(ArrayList<Student> students, ArrayList<Grade> grades) throws Exception {
        return students
                .stream()
                .filter((student) -> {
                    try {
                        getAverageGradeForStudent(student, grades);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .sorted(new AverageGradeComparator(grades))
                .toList();
    }
}
