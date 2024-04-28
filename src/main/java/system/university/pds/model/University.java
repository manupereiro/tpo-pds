package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Getter
public class University {
    private final Map<BigInteger, Degree> degrees;
    private static University instance = null;

    private University() {
        this.degrees = new HashMap<>();
    }

    public void addDegree(Degree degree){
        degrees.put(degree.getId(), degree);

    }
    public static University getInstance() {
        if (instance == null) {
            instance = new University();
        }
        return instance;
    }

}
