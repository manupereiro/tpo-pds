package system.university.pds.controller;

import system.university.pds.model.Teacher;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TeacherController {
    private Map<BigInteger, Teacher> teachers;

    public TeacherController() {
        this.teachers = new HashMap<>();
    }

    public void signUpToCourse(Teacher teacher, BigInteger courseId){
        return;
    }
}
