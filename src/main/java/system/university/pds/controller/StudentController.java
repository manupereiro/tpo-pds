package system.university.pds.controller;

import system.university.pds.model.Student;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class StudentController {

    private Map<BigInteger, Student> students;

    public StudentController() {
        this.students = new HashMap<>();
    }

    public void signUpToCourse(Student student, BigInteger courseId){
        return;
    }
}
