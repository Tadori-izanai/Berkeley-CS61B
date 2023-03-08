package examprep08;

import java.util.ArrayList;

public class TA {
    int charisma;
    String name;

    TA(String name, int charisma) {
        this.name = name;
        this.charisma = charisma;
    }

    @Override
    public boolean equals(Object o) {
        TA other = (TA) o;
        return other.name.charAt(0) == this.name.charAt(0);
    }

    @Override
    public int hashCode() {
        return charisma;
    }

    @Override
    public String toString() {
        return name + Integer.toString(charisma);
    }
}
