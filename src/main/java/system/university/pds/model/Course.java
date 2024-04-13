package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Course {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final BigInteger degreeId;
    private String name;
    private List<BigInteger> teachers;
    private List<BigInteger> students;
    private Classroom classroom;
    private Map<String, Subject> prerequisitesCourses;
    private Map<String, Subject> subsequentCourses;
    private LocalTime startTime;
    private LocalTime endTime;
    private short duration;
    private double price;

    public Course(BigInteger degreeId,
                  String name,
                  Classroom classroom,
                  LocalTime startTime,
                  LocalTime endTime,
                  short duration,
                  double price) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.degreeId = degreeId;
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
        List<Subject> studentPassedSubjects = student.getPassedSubjects();
        for (Subject subject : prerequisitesCourses.values()) {
            if (!studentPassedSubjects.contains(subject)){
                return false;
            }
        }
        return true;
    }

    public boolean checkTotalHours(List<Course> studentCourses){
        University university = new University();
        Degree degree = university.getDegrees().get(degreeId);
        short totalHours = 0;
        for (Course course : studentCourses) {
            totalHours += course.duration;
        }
        return totalHours + this.duration <= degree.getHoursPerSemester();
    }

    public void addStudentToCourse(BigInteger student){
        this.students.add(student);
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
