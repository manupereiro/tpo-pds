package system.university.pds.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;


public abstract class User {

    private static int CURRENT_ID = 0;
    @Getter
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final String password;
    @Getter
    private final List<Course> assignedCourses;

    public User(String name, String password) {
        this.id = CURRENT_ID;
        CURRENT_ID++;
        this.name = name;
        this.password = password;
        this.assignedCourses = new ArrayList<>();
    }

    public void addCourse(Course course){
        assignedCourses.add(course);
    }
}
