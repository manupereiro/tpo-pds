package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Teacher;
import system.university.pds.model.User;
import system.university.pds.model.interfaces.ScheduleObserver;
import system.university.pds.model.interfaces.ScheduleSubject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TeacherController implements ScheduleSubject {
    private Map<Integer, Teacher> teachers;
    private Set<ScheduleObserver> observers;
    private static TeacherController instance = null;

    public static TeacherController getInstance() {
        if (instance == null) {
            instance = new TeacherController();
        }
        return instance;
    }

    private TeacherController() {
        this.teachers = new HashMap<>();
        this.observers = new HashSet<>();
    }

    public void signUpToCourse(User teacher, int courseId){
        CourseController courseController = CourseController.getInstance();
        Course course = courseController.getCourse(courseId);
        course.addTeacherToCourse(teacher.getId());
        teacher.addCourse(course);
        notifyObservers();
    }
    public void addTeacher(User teacher){
        teachers.put(teacher.getId(), (Teacher) teacher);
        notifyObservers();
    }

    @Override
    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ScheduleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ScheduleObserver observer : observers) {
            observer.update(teachers.get(1));
        }
    }
}
