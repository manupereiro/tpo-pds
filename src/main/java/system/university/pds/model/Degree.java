package system.university.pds.model;

import java.math.BigInteger;

public class Degree {

    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private String name;
    private short hoursPerSemester;

    public Degree(String name, short hoursPerSemester) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.hoursPerSemester = hoursPerSemester;
    }
}
