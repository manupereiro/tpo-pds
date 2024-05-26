package system.university.pds.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Degree {

    private static int CURRENT_ID = 0;
    private final int id;
    private final String name;
    private final short hoursPerSemester;
    private final Map<Integer, Subject> subjects;

    public Degree(String name, short hoursPerSemester) {
        this.id = CURRENT_ID;
        CURRENT_ID++;
        this.name = name;
        this.hoursPerSemester = hoursPerSemester;
        this.subjects = new HashMap<>();
    }


}
