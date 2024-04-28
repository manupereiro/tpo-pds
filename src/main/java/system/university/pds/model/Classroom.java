package system.university.pds.model;

import lombok.Getter;

public record Classroom(@Getter int classroomNumber, short capacity) {
    public Classroom {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }
}
