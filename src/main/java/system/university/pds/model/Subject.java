package system.university.pds.model;

import lombok.Getter;

import java.util.*;

@Getter
public class Subject {
    private static int CURRENT_ID = 0;
    private final int id;
    private final String name;
    private final Map<Integer, Course> courses;
    private final Date inscriptionDate;
    private final Date deadline;
    private final List<Subject> prerequisitesSubjects;
    private final List<Subject> subsequentSubjects;

    public Subject(String name, Date inscriptionDate, Date deadline){
        this.id = CURRENT_ID;
        CURRENT_ID++;
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
            } else {
                System.out.println(course);
            }
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
