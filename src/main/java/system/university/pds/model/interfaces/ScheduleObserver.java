package system.university.pds.model.interfaces;

import system.university.pds.model.Teacher;
import system.university.pds.model.User;

public interface ScheduleObserver {
    void update(User teacher);
}
