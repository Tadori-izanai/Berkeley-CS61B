package disc02;

public class Pokemon {
    public String name;
    public int level;

    public Pokemon(String name, int level) {
        this.name = name;   // 不指明 this, name 和 level 指的是参数列列表中的 this 和 level
        this.level = level;
    }

    public static void change(Pokemon poke, int level) {
        poke.level = level;
        level = 50;
        poke = new Pokemon("Gengar", 1);            // Lv1 的耿鬼
    }

    public static void main(String[] args) {
        Pokemon p = new Pokemon("Picachu", 17);     // Lv17 的皮卡丘
        int level = 100;
        change(p, 100);
        System.out.println("Name: " + p.name + ", Level: " + p.level);
    }
}
