package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{
    @Getter
    private List<Course> coursesAssigned;

    public Teacher(String name, String email, String password){
        super(name, email, password);
        this.coursesAssigned = new ArrayList<>();
    }

    public List<Course> searchCoursesOfEachTeacher(BigInteger teacherId){
        return null;
    }

}
