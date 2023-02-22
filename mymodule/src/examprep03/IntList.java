package examprep03;

import com.sun.jdi.ArrayReference;
import com.sun.source.doctree.TextTree;

import java.awt.event.ItemListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class IntList {
    private int first;
    private IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }
    public IntList(int[] items) {
        int k = items.length - 1;
        IntList L = new IntList(items[k--], null);
        while (k >= 0) {
            L = new IntList(items[k--], L);
        }
        this.first = L.first;
        this.rest = L.rest;
    }

    public String toString() {
        String s = "" + this.first;
        for (IntList p = this.rest; p != null; p = p.rest) {
            s += " -> " + p.first;
        }
        return s;
    }

    public static IntList reverse(IntList lst) {
        if (lst == null || lst.rest == null) {
            return lst;
        }
        IntList retVal = new IntList(lst.first, null);
        for (IntList p = lst.rest; p != null; p = p.rest) {
            retVal = new IntList(p.first, retVal);
        }
        return retVal;
    }


    public static void main(String[] args) {
        evenLauncher();
        partitionLauncher();
    }
    public static void evenLauncher() {
        int[] test = {0, 3, 1, 4, 2, 5};
        IntList L = new IntList(test);
        System.out.println(L);              // 省略: L.toString()

        evenOdd(L);
        System.out.println(L);
    }
    public static void partitionLauncher() {
        int[] test = {5, 4, 3, 2, 1};
        IntList L = new IntList(test);
        int k = 2;
        IntList[] result = partition2(L, k);

        for (IntList lst : result) {
            System.out.println(lst);
        }
    }


    public static void evenOdd2(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList tmp = lst.rest;
        IntList q = lst.rest;

        while (true) {
            if (q.rest == null) {
                lst.rest = null;
                break;
            }
            lst.rest = q.rest;
            lst = lst.rest;
            if (lst.rest == null) {
                q.rest = null;
                break;
            }
            q.rest = lst.rest;
            q = q.rest;
        }
        lst.rest = tmp;
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList tmp = lst.rest;
        IntList q = lst.rest;

        // 退出的条件还可以是 q == null (奇数个 nodes) || q.rest == null (偶数个 nodes)
//        while (q != null && q.rest != null) {       // 先判断 q 不是 null 才能判断 q.rest 不是 null
        while (lst.rest != null && q.rest != null) {
//        while (q.rest != null && lst.rest != null) {    // 不可以的, 因为奇数个 nodes 时, lst.rest == null 时, 已经 q == null 了, 访问 q.rest 则报错
            lst.rest = lst.rest.rest;
            q.rest = q.rest.rest;
            lst = lst.rest;
            q = q.rest;
        }
        lst.rest = tmp;
    }

    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);

        while (L != null) {
            IntList prevAtIndex = array[index];
            IntList next = L.rest;
            array[index] = L;
            array[index].rest = prevAtIndex;
            L = next;
            index = (index + 1) % array.length;
        }
        return array;
    }

    public static IntList[] partition2(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);

        while (L != null) {
            IntList next = L.rest;          // 暂存下一个 L 的位置

            L.rest = array[index];          // 指向了前一次 array[index] 所在的位置
            array[index] = L;               // 更新 array[index] 的位置

            L = next;
            index = (index + 1) % k;
        }
        return array;
    }
}
