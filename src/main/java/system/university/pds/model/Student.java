package system.university.pds.model;

import lombok.Getter;
import system.university.pds.controller.SubjectController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Student extends User{

    private List<Course> coursesEnrolled;

    private List<Subject> passedSubjects;

    public Student(String name, String email, String password){
        super(name, email, password);
        this.coursesEnrolled = new ArrayList<>();
        this.passedSubjects = new ArrayList<>();
    }

    public void checkCourses(BigInteger courseId){
        SubjectController subjectController = new SubjectController();
        Subject subject = subjectController.getSubject(courseId);
        subject.displayCourses();
    }


}
