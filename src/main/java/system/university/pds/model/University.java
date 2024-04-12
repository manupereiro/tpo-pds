package system.university.pds.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class University {
    private Map<BigInteger, Degree> degrees;

    public University() {
        this.degrees = new HashMap<>();
    }
}
