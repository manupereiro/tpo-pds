package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Course {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final BigInteger degreeId;
    private final Subject subject;
    private final List<BigInteger> teachers;
    private final List<BigInteger> students;
    private final Classroom classroom;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final short duration;
    private final double price;

    public Course(BigInteger degreeId,
                  Subject subject,
                  Classroom classroom,
                  LocalTime startTime,
                  LocalTime endTime,
                  short duration,
                  double price) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.degreeId = degreeId;
        this.subject = subject;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classroom = classroom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.price = price;
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
    public void addTeacherToCourse(BigInteger teacher){
        this.teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id +
                ", teachers=" + teachers +
                ", students=" + students +
                ", classroom=" + classroom +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", price=" + price + '}';
    }
}
