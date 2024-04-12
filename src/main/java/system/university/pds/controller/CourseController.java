package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Student;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseController {
    private Map<BigInteger, Course> courses;

    public CourseController() {
        this.courses = new HashMap<>();
    }

    public void addStudentToRegisteredCourse(Student student, BigInteger courseId){
        return;
    }

    public List<Course> searchCoursesOfEachTeacher(BigInteger teacherId){
        return null;
    }
}
