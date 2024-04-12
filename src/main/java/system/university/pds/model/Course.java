package system.university.pds.model;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private String name;
    private List<Teacher> teachers;
    private List<Student> students;
    private Classroom classroom;
    private Map<String, Subject> prerequisitesCourses;
    private Map<String, Subject> subsequentCourses;
    private LocalTime startTime;
    private LocalTime endTime;
    private short duration;
    private double price;

    public Course(String name,
                  Classroom classroom,
                  LocalTime startTime,
                  LocalTime endTime,
                  short duration,
                  double price) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classroom = classroom;
        this.prerequisitesCourses = new HashMap<>();
        this.subsequentCourses = new HashMap<>();
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.price = price;
    }

    public boolean checkPrerequisitesCourses(Student student){
        return false;
    }

    public void addStudentToCourse(Student student){
        this.students.add(student);
    }

    public boolean checkTotalHours(List<Course> studentCourses, short totalHoursPerSemester){
        return false;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id +
                ", name=" + name +
                ", teachers=" + teachers +
                ", students=" + students +
                ", classroom=" + classroom +
                ", prerequisitesCourses=" + prerequisitesCourses +
                ", subsequentCourses=" + subsequentCourses +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", price=" + price + '}';
    }
}
