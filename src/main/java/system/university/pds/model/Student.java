package system.university.pds.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Student extends User{

    private final List<Subject> passedSubjects;

    public Student(String name, String password){
        super(name, password);
        this.passedSubjects = new ArrayList<>();
    }

}
