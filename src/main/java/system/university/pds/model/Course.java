package system.university.pds.model;

import lombok.Getter;
import lombok.Setter;
import system.university.pds.model.interfaces.CourseObserver;
import system.university.pds.model.interfaces.CourseSubject;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Course implements CourseSubject {
    private static int CURRENT_ID = 0;
    private final int id;
    private final Subject subject;
    private final List<Integer> teachers;
    private final List<Integer> students;
    private final Classroom classroom;
    private final short duration;
    private final double price;
    private Turn turn;
    private final DayOfWeek day;
    private final Set<CourseObserver> observers;

    public Course(Subject subject,
                  Classroom classroom,
                  short duration,
                  double price,
                  DayOfWeek day) {
        this.id = CURRENT_ID;
        CURRENT_ID++;
        this.subject = subject;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classroom = classroom;
        this.duration = duration;
        this.price = price;
        this.day = day;
        this.observers = new HashSet<>();
    }

    public boolean checkPrerequisitesCourses(User student){
        List<Subject> studentPassedSubjects = ((Student) student).getPassedSubjects();
        List<Subject> prerequisitesSubjects = this.subject.getPrerequisitesSubjects();
        for (Subject subjectCandidate : prerequisitesSubjects) {
            if (!studentPassedSubjects.contains(subjectCandidate)){
                return false;
            }
        }
        return true;
    }

    public boolean checkTotalHours(List<Course> studentCourses, short totalHoursDegree){
        short totalHours = 0;
        for (Course course : studentCourses) {
            totalHours += course.duration;
        }
        return totalHours + this.duration <= totalHoursDegree;
    }

    public void addStudentToCourse(int student){
        this.students.add(student);
    }
    public void addTeacherToCourse(int teacher){
        this.teachers.add(teacher);
    }


    @Override
    public void addObserver(CourseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CourseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CourseObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id +
                ", teachers=" + teachers +
                ", students=" + students +
                ", classroom=" + classroom +
                ", duration=" + duration +
                ", price=" + price +
                ", turn=" + turn +
                ", day=" + day +
                '}';
    }
}
