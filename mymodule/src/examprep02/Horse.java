package examprep02;

public class Horse {
    Horse same;         // default: 默认访问方式, 只允许在同一个包内可以访问
    String jimmy;

    public Horse(String lee) {
        jimmy = lee;
    }

    public Horse same(Horse horse) {
        if (same != null) {
            Horse same = horse;     // 注意这里创建了一个 reference 叫做 same
            same.same = horse;      // 不是 this.same
            same = horse.same;
        }                           // same 卒
        return same.same;
    }

    public static void main(String[] args) {
        Horse horse = new Horse("youve been");
        Horse cult = new Horse("horsed");
        cult.same = cult;
        cult = cult.same(horse);

        System.out.println(cult.jimmy);
        System.out.println(horse.jimmy);
    }
}
