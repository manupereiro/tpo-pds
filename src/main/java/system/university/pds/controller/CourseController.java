package system.university.pds.controller;

import lombok.Getter;
import system.university.pds.model.Classroom;
import system.university.pds.model.Course;
import system.university.pds.model.interfaces.CourseObserver;
import system.university.pds.model.User;

import java.time.DayOfWeek;
import java.util.*;

public class CourseController implements CourseObserver {
    @Getter
    private final Map<Integer, Course> courses;
    private static CourseController instance = null;
    private static Random random = new Random();

    private CourseController() {
        this.courses = new HashMap<>();
    }

    public static CourseController getInstance() {
        if (instance == null) {
            instance = new CourseController();
        }
        return instance;
    }

    public void addStudentToRegisteredCourse(User student, int courseId){
        List<Course> studentAssignedCourseAlready = student.getAssignedCourses();
        studentAssignedCourseAlready.add(courses.get(courseId));

    }

    public Course getCourse(int courseId){
        return courses.get(courseId);
    }

    public void addCourse(Course course){
        courses.put(course.getId(), course);
        course.notifyObservers();
    }


    @Override
    public void update(Course course) {
        Classroom classroom = new Classroom(
                random.nextInt(1000) + 1,
                (short) (random.nextInt(65) + 1));
        DayOfWeek day = DayOfWeek.of(random.nextInt(7) + 1);
        Course newCourse = new Course(course.getSubject(),
                classroom,
                course.getDuration(),
                course.getPrice(),
                day);
        newCourse.setTurn(course.getTurn());
        addCourse(newCourse);
    }
}
