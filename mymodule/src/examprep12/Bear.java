package examprep12;

public class Bear extends Bed {
    public Bear(int x) {
        super(x);
    }

    public int compareToBed(Bed b) {
        return this.value - b.value;
    }
}
