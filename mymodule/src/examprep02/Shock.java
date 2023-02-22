package examprep02;

public class Shock {
    public static int bang;     // 注意是 static
    public static Shock baby;   // 注意是 static

    public Shock() {
        bang = 100;
    }

    public Shock(int num) {
        bang = num;
        baby = starter();
        bang += num;
    }

    public static Shock starter() {
        Shock gear = new Shock();
        return gear;
    }

    public static void shrink(Shock statik) {
        statik.bang -= 1;
    }

    public static void main(String[] args) {
        Shock gear = new Shock(200);
        System.out.println(gear.bang);      // 300
        shrink(gear);
        shrink(starter());
        System.out.println(gear.bang);      // 99
    }
}
