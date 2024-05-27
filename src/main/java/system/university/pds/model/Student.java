package system.university.pds.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Student extends User{

    private final List<Subject> passedSubjects;
    private final int degreeId;

    public Student(String name, String password, int degreeId){
        super(name, password);
        this.passedSubjects = new ArrayList<>();
        this.degreeId = degreeId;
    }

    public void passSubject(Subject subject){
        passedSubjects.add(subject);
    }

}
