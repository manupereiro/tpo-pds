package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Degree {

    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final String name;
    private final short hoursPerSemester;
    private final Map<BigInteger, Subject> subjects;

    public Degree(String name, short hoursPerSemester) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.hoursPerSemester = hoursPerSemester;
        this.subjects = new HashMap<>();
    }


}
