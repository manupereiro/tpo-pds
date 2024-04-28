package system.university.pds.controller;

import system.university.pds.model.*;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StudentController {

    private final Map<BigInteger, Student> students;
    private static StudentController instance = null;

    public static StudentController getInstance() {
        if (instance == null) {
            instance = new StudentController();
        }
        return instance;
    }

    private StudentController() {
        this.students = new HashMap<>();
    }


    public void checkCourses(BigInteger courseId){
        SubjectController subjectController = SubjectController.getInstance();
        Subject subject = subjectController.getSubject(courseId);
        subject.displayCourses();
    }

    public void signUpToCourse(BigInteger studentId, BigInteger courseId){
        CourseController courseController = CourseController.getInstance();
        User student = students.get(studentId);
        Course course = courseController.getCourse(courseId);
        Subject subject = course.getSubject();
        University university = University.getInstance();
        Degree degree = university.getDegrees().get(((Student) student).getDegreeId());
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        if (date.before(subject.getInscriptionDate()) || date.after(subject.getDeadline())){
            System.out.println("You can't sign up to this course");
            return;
        }

        boolean prerequisitesCourses = course.checkPrerequisitesCourses(student);
        boolean scheduleIsNotFull = course.checkTotalHours(student.getAssignedCourses(), degree.getHoursPerSemester());

        if (prerequisitesCourses && scheduleIsNotFull){
            course.addStudentToCourse(student.getId());
            courseController.addStudentToRegisteredCourse(student, course.getId());
            student.addCourse(course); // add the course to the student list

            System.out.println("You have been, successfully, signed up to the course");

        }
    }

    public void addStudent(User student){

        students.put(student.getId(), (Student) student);
    }

}
