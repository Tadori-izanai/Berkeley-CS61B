package examprep08;

public class Launcher {
    public static void main(String[] args) {
        ECHashMap<TA, Integer> map = new ECHashMap<>();
        TA sohum = new TA("Sohum", 10);
        TA vivant = new TA("Vivant", 20);

        map.put(sohum, 1);
        map.put(vivant, 2);

        vivant.charisma += 2;
        map.put(vivant, 3);

        sohum.name = "Vohum";
        map.put(vivant, 4);

        sohum.charisma += 2;
        map.put(sohum, 5);

        sohum.name = "Sohum";
        TA shubha = new TA("Subha", 24);
        map.put(shubha, 6);

        map.printAll();
    }
}
