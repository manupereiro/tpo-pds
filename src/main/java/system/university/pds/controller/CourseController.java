package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.User;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseController {
    private final Map<BigInteger, Course> courses;
    private static CourseController instance = null;

    private CourseController() {
        this.courses = new HashMap<>();
    }

    public static CourseController getInstance() {
        if (instance == null) {
            instance = new CourseController();
        }
        return instance;
    }

    public void addStudentToRegisteredCourse(User student, BigInteger courseId){
        List<Course> studentAssignedCourseAlready = student.getAssignedCourses();
        studentAssignedCourseAlready.add(courses.get(courseId));
    }

    public Course getCourse(BigInteger courseId){
        return courses.get(courseId);
    }

    public void addCourse(Course course){
        courses.put(course.getId(), course);
    }


}
