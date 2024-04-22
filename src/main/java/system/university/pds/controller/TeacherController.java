package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Teacher;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TeacherController {
    private Map<BigInteger, Teacher> teachers;

    private static TeacherController instance = null;

    public static TeacherController getInstance() {
        if (instance == null) {
            instance = new TeacherController();
        }
        return instance;
    }

    private TeacherController() {
        this.teachers = new HashMap<>();
    }

    public void signUpToCourse(Teacher teacher, BigInteger courseId){
        CourseController courseController = CourseController.getInstance();
        Course course = courseController.getCourse(courseId);
        course.addTeacherToCourse(teacher.getId());
        teacher.addCourse(course);
    }
}
