package system.university.pds.model;

import java.math.BigInteger;

public abstract class User {

    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    private final BigInteger id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
