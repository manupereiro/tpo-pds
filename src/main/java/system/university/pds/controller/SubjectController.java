package system.university.pds.controller;

import system.university.pds.model.Subject;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SubjectController {

    private Map<BigInteger, Subject> subjects;
    private static SubjectController instance = null;

    public static SubjectController getInstance() {
        if (instance == null) {
            instance = new SubjectController();
        }
        return instance;
    }

    private SubjectController() {
        this.subjects = new HashMap<>();
    }

    public Subject getSubject(BigInteger subjectId){
        return subjects.get(subjectId);
    }
}
