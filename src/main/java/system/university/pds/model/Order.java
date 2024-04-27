package system.university.pds.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<BigInteger, Course> courses;
    private final User student;

    public Order(User student) {
        this.courses = new HashMap<>();
        this.student = student;
    }

    public List<Course> getCourses(){
        return (List<Course>) courses.values();
    }

    public void addCourse(BigInteger courseId, Course course){
        courses.put(courseId, course);
    }
}
