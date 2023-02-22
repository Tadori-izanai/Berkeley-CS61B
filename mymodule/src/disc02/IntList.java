package disc02;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // 不改变实参 (recursively)
    public static IntList square(IntList L) {
        if (L == null)
            return null;
        IntList r = square(L.rest);
        IntList M = new IntList(L.first * L.first, r);
        return M;
    }

    // 改变实参 (recursively)
    public static IntList squareMutative(IntList L) {
        if (L == null)
            return null;
        squareMutative(L.rest);
        L.first *= L.first;
        return L;
    }

    // 不改变实参 (iteratively)
    public static IntList squareIterative(IntList L) {
        IntList result = new IntList(L.first * L.first, null);
        IntList p = result;
        L = L.rest;
        while (L != null) {
            p.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            p = p.rest;
        }
        return result;
    }

    // 改变参数 (iteratively)
    public static IntList squareMutativeIterative(IntList L) {
        IntList result = L;
        while (L != null) {
            L.first *= L.first;
            L = L.rest;
        }
        return result;
    }




    public static String toString(IntList L) {
        String result = "";
        for (IntList iter = L; iter != null; iter = iter.rest)
            result = result + Integer.toString(iter.first) + " -> ";
        result = result + "null";
        return result;
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L = new IntList(2, L);
        L = new IntList(1, L);

        System.out.println(IntList.toString(IntList.square(L)));
        System.out.println(IntList.toString(L));
        System.out.println(IntList.toString(IntList.squareMutative(L)));
        System.out.println(IntList.toString(L));
        System.out.println("---------------------");
        System.out.println(IntList.toString(IntList.squareIterative(L)));
        System.out.println(IntList.toString(L));
        System.out.println(IntList.toString(IntList.squareMutativeIterative(L)));
        System.out.println(IntList.toString(L));
    }
}
