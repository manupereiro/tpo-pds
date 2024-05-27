package system.university.pds.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Integer, Course> courses;
    private final User student;

    public Order(User student) {
        this.courses = new HashMap<>();
        this.student = student;
    }

    public List<Course> getCourses(){
        return (List<Course>) courses.values();
    }

    public void addCourse(int courseId, Course course){
        courses.put(courseId, course);
    }
}
