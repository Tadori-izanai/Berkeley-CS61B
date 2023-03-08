package chap11;

public class TestRotate {
    public static void main(String[] args) {
        BSTMap<String, Integer> touhou = new BSTMap<>();
        touhou.put("Cirno", 9);
        touhou.put("Lumia", 10);
        touhou.put("Satori", 5);
        touhou.put("Utsuho", 6);
        touhou.put("Koishi", 114);
        touhou.put("Koishi", 514);

        touhou.printInOrder();
        touhou.rotateRootLeft();
        touhou.rotateRootRight();
    }
}
