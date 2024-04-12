package system.university.pds.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Subject {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private String name;
    private Map<BigInteger, Course> courses;

    public Subject(String name){
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.courses = new HashMap<>();
    }

    public void displayCourses(){
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
}
