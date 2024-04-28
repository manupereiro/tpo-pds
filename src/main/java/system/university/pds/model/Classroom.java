package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;

public record Classroom(@Getter BigInteger classroomNumber, short capacity) {
    public Classroom {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }
}
