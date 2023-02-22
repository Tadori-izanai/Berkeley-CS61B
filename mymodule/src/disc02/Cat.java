package disc02;

public class Cat {
    public String name;
    public static String noise;     // 注意此处的 static, 表示 noise 是 Cat class 所有 object 共有的属性

    public Cat(String name, String noise) {
        this.name = name;
        this.noise = noise;
    }

    public void play() {
        System.out.println(noise + " I'm " + name + " the cat!");
    }

    public static void anger() {
        noise = noise.toUpperCase();
    }
    // 好像不能是 static
    public void calm() {
        noise = noise.toLowerCase();
    }

    public static void main(String[] args) {
        Cat a = new Cat("Cream", "Meow!");      // Meow
        Cat b = new Cat("Tobbs", "Nyan!");      // Nyan

        a.play();
        b.play();
        Cat.anger();    // NYAN
        a.calm();       // nyan
        a.play();
        b.play();
    }
}
