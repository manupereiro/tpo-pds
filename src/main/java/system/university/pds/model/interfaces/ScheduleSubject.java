package system.university.pds.model.interfaces;

public interface ScheduleSubject {
    void addObserver(ScheduleObserver observer);
    void removeObserver(ScheduleObserver observer);
    void notifyObservers();
}
