package system.university.pds.model;

import lombok.Getter;

import java.math.BigInteger;

public abstract class User {

    private static BigInteger CURRENT_ID = BigInteger.ZERO;
    @Getter
    private final BigInteger id;
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private String password;
    // comentario
    public User(String name, String email, String password) {
        this.id = CURRENT_ID;
        CURRENT_ID = CURRENT_ID.add(BigInteger.ONE);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
