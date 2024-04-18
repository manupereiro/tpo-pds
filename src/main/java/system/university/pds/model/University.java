package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Getter
public class University {
    private final Map<BigInteger, Degree> degrees;

    public University() {
        this.degrees = new HashMap<>();
    }
}
