package chap04.compares;

import java.util.Comparator;

//public class Dog implements OurComparable {
public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    @Override
//    public int compareTo(Object o) {
//        Dog uddaDog = (Dog) o;
//        return this.size - uddaDog.size;
//    }
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }



    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);    // 使用 String.compareTo()
        }
    }

    public static Comparator<Dog> genNameComparator() {
        return new NameComparator();
    }

}
