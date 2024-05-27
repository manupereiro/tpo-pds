package system.university.pds.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{

    private List<DayOfWeek> availableDays;
    private List<Turn> availableTurns;
    private short assignedHours;

    public Teacher(String name, String password){
        super(name, password);
        this.availableDays = new ArrayList<>();
        this.availableTurns = new ArrayList<>();
    }

    @Override
    public List<Course> getAssignedCourses() {
        return super.getAssignedCourses();
    }

    public void addAvailableDay(DayOfWeek day){
        availableDays.add(day);
    }

    public void addAvailableTurn(Turn turn){
        availableTurns.add(turn);
    }

    public void assignHours(short hours){
        assignedHours += hours;
    }
}
