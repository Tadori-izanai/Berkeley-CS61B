package tests;

import java.io.Serializable;

public class Model implements Serializable {
    private int val = 0;
    public Model(int val) {
        this.val = val;
    }
    public int val() {
        return val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
