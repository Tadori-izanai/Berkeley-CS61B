package chap04.compares;

import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)
        };
        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();


        Comparator<Dog> nc = Dog.genNameComparator();
        if (nc.compare(dogs[0], dogs[1]) > 0) {
            dogs[0].bark();
        } else if (nc.compare(dogs[0], dogs[1]) < 0) {
            dogs[1].bark();
        }
    }
}
