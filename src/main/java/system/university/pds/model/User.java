package system.university.pds.model;

import lombok.Getter;
import java.math.BigInteger;

@Getter
public abstract class User {

    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private final String name;
    private final String email;
    private final String password;

    public User(String name, String email, String password) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
