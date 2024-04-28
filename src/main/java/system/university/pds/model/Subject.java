package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.*;

@Getter
public class Subject {
    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final String name;
    private final Map<BigInteger, Course> courses;
    private final Date inscriptionDate;
    private final Date deadline;
    private final List<Subject> prerequisitesSubjects;
    private final List<Subject> subsequentSubjects;

    public Subject(String name, Date inscriptionDate, Date deadline){
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.courses = new HashMap<>();
        this.inscriptionDate = inscriptionDate;
        this.deadline = deadline;
        this.prerequisitesSubjects = new ArrayList<>();
        this.subsequentSubjects = new ArrayList<>();
    }

    public void displayCourses(){
        for (Course course : courses.values()) {
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            if (date.before(inscriptionDate) || date.after(deadline)){
                System.out.println(course.getSubject().getName() + "is not available");
            }
            System.out.println(course);
        }
    }
    public void addCourse(Course course){
        courses.put(course.getId(), course);
    }

    public void addPrerequisiteSubject(Subject subject){
        prerequisitesSubjects.add(subject);
    }

    public void addSubsequentSubject(Subject subject){
        subsequentSubjects.add(subject);
    }
}
