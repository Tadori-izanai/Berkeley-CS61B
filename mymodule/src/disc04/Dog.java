package disc04;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
        noise = "Woof!";
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + this.noise);
    }

    public void play(int happiness) {
        if (happiness > 10) {
            System.out.println("Woo it is so much fun being a dog!");
        }
    }
}
