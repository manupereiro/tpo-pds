package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Subject {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final String name;
    private final Map<BigInteger, Course> courses;
    private final Date startingDay;
    private final Date deadline;

    public Subject(String name, Date startingDay, Date deadline){
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.courses = new HashMap<>();
        this.startingDay = startingDay;
        this.deadline = deadline;
    }

    public void displayCourses(){
        for (Course course : courses.values()) {
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            if (date.before(startingDay) || date.after(deadline)){
                System.out.println(course.getName() + "is not available");
            }
            System.out.println(course);
        }
    }
}
