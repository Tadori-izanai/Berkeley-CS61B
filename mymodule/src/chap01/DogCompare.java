package chap01;

public class DogCompare {
    public static void main(String[] args) {
        Dog d = new Dog(15);
        Dog d2 = new Dog(100);
        Dog dogMax = Dog.maxDog(d, d2);
        dogMax.makeNoise();
        System.out.println(dogMax.weighInPounds);

        dogMax = d2.heavierDog(d);
        dogMax.makeNoise();
        System.out.println(dogMax.weighInPounds);

        System.out.println(Dog.binomen);
    }
}

