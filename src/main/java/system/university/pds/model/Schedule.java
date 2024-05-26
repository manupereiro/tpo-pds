package system.university.pds.model;

import system.university.pds.model.interfaces.ScheduleObserver;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule implements ScheduleObserver {

    private Map<DayOfWeek, List<Integer>> daysOfTeachersTeach;
    private Map<Integer, List<Course>> coursesByTeacher;

    public Schedule() {
        this.daysOfTeachersTeach = new HashMap<>();
        addDaysToMap();
        this.coursesByTeacher = new HashMap<>();
    }

    @Override
    public void update(User teacher) {
        List<Course> course = teacher.getAssignedCourses();
        for (Course c : course) {
            DayOfWeek day = c.getDay();
            if (daysOfTeachersTeach.get(day) == null) {
                List<Integer> teachers = new ArrayList<>();
                teachers.add(teacher.getId());
                daysOfTeachersTeach.put(day, teachers);
            } else {
                daysOfTeachersTeach.get(day).add(teacher.getId());
            }
        }
        coursesByTeacher.put(teacher.getId(), course);
    }

    private void addDaysToMap(){
        for (DayOfWeek day : DayOfWeek.values()) {
            daysOfTeachersTeach.put(day, null);
        }
    }
}
