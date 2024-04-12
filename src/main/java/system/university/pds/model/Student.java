package system.university.pds.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private List<Course> coursesEnrolled;

    private List<Subject> passedSubjects;

    public Student(String name, String email, String password){
        super(name, email, password);
        this.coursesEnrolled = new ArrayList<>();
        this.passedSubjects = new ArrayList<>();
    }

    public void checkCourses(BigInteger courseId){
        return;
    }
}
