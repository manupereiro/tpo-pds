package system.university.pds.controller;

import lombok.Getter;
import system.university.pds.model.Subject;

import java.util.HashMap;
import java.util.Map;

public class SubjectController {

    @Getter
    private Map<Integer, Subject> subjects;
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

    public Subject getSubject(int subjectId){
        return subjects.get(subjectId);
    }

    public void Correlate (Subject subject1, Subject subject2){
        subject1.addSubsequentSubject(subject2);
        subject2.addPrerequisiteSubject(subject1);
    }

    public void addSubject(Subject subject){
        subjects.put(subject.getId(), subject);
    }
}
