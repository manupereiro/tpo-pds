package system.university.pds.model.interfaces;

public interface CourseSubject {
    void addObserver(CourseObserver observer);
    void removeObserver(CourseObserver observer);
    void notifyObservers();
}
