package system.university.pds.model;

import java.util.Arrays;

public enum Turn {
    MORNING,
    EVENING,
    NIGHT;

    public static Turn fromString(String turn){
        return Arrays.stream(Turn.values())
                .filter(t -> t.name().equalsIgnoreCase(turn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid turn"));
    }

    public boolean equals(Turn turn){
        return this.name().equalsIgnoreCase(turn.name());
    }
}
