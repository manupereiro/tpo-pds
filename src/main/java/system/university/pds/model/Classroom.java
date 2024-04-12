package system.university.pds.model;

import java.math.BigInteger;

public record Classroom(BigInteger id, short capacity) {
    public Classroom {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }
}
