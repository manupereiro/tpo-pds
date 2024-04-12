package system.university.pds.controller;

import system.university.pds.model.Subject;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SubjectController {

    private Map<BigInteger, Subject> subjects;

    public SubjectController() {
        this.subjects = new HashMap<>();
    }

    public Subject getSubject(BigInteger subjectId){
        return null;
    }
}
