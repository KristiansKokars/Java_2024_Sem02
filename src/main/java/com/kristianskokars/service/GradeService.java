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

    public static void sortStudentsByAverageGrade(ArrayList<Student> students, ArrayList<Grade> grades) throws Exception {
        // Easiest option
//        students.sort(new AverageGradeComparator(grades));

        // Manual option
        var cachedStudentGrades = new HashMap<Long, Double>();

        var length = students.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                double firstStudentGrade;
                Student firstStudent = students.get(j);
                if (cachedStudentGrades.containsKey(firstStudent.getId())) {
                    firstStudentGrade = cachedStudentGrades.get(firstStudent.getId());
                } else {
                    firstStudentGrade = getAverageGradeForStudent(firstStudent, grades);
                    cachedStudentGrades.put(firstStudent.getId(), firstStudentGrade);
                }

                double secondStudentGrade;
                Student secondStudent = students.get(j + 1);
                if (cachedStudentGrades.containsKey(secondStudent.getId())) {
                    secondStudentGrade = cachedStudentGrades.get(secondStudent.getId());
                } else {
                    secondStudentGrade = getAverageGradeForStudent(secondStudent, grades);
                    cachedStudentGrades.put(secondStudent.getId(), secondStudentGrade);
                }

                if (firstStudentGrade > secondStudentGrade) {
                    students.set(i, secondStudent);
                    students.set(j, firstStudent);
                }
            }
        }
    }
}
