package disc04;

public class Animal {
    public String name;
    public String noise;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.noise = "Huh?";
    }

    public void greet() {
        System.out.println("Animal " + name + " says: " + this.noise);
    }

    public void play() {
        System.out.println("Woo it is so much fun being an animal!");
    }
}
