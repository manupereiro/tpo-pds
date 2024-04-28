package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Student extends User{

    private final List<Subject> passedSubjects;
    private final BigInteger degreeId;

    public Student(String name, String password, BigInteger degreeId){
        super(name, password);
        this.passedSubjects = new ArrayList<>();
        this.degreeId = degreeId;
    }

    public void passSubject(Subject subject){
        passedSubjects.add(subject);
    }

}
