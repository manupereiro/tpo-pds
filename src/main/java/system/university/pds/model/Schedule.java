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
        if (teacher == null) {
            return; // Evitar NullPointerException
        }

        List<Course> courses = teacher.getAssignedCourses();
        if (courses == null) {
            return; // Evitar NullPointerException
        }

        for (Course c : courses) {
            DayOfWeek day = c.getDay();
            daysOfTeachersTeach.putIfAbsent(day, new ArrayList<>());

            List<Integer> teachers = daysOfTeachersTeach.get(day);
            if (!teachers.contains(teacher.getId())) {
                teachers.add(teacher.getId());
            }
        }

        coursesByTeacher.put(teacher.getId(), courses);
    }


    private void addDaysToMap(){
        for (DayOfWeek day : DayOfWeek.values()) {
            daysOfTeachersTeach.put(day, null);
        }
    }
}
