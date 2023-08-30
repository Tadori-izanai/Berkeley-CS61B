package examprep13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MSDRadixSort {
    public static List<String> msd(List<String> items) {
        return msd(items, 0);
    }

    private static List<String> msd(List<String> items, int index) {
        if (index >= items.get(0).length() || items.size() <= 1) {
            return items;
        }

        List<String> answer = new ArrayList<>();
        int start = 0;

        stableSort(items, index);

        for (int end = 1; end <= items.size(); end += 1) {
            if (end == items.size() || items.get(start).charAt(index) != items.get(end).charAt(index)) {
                List<String> subList = items.subList(start, end);
                answer.addAll(msd(subList, index + 1));
                start = end;
            }
        }

        return answer;
    }


    // sorts the given list of strings in place, comparing two strings by given index
    private static void stableSort(List<String> items, int index) {
        items.sort(Comparator.comparingInt(o -> o.charAt(index)));
    }

    public static void main(String[] args) {
        List<String> touhou = new ArrayList<>();
        touhou.add("Reimu");
        touhou.add("Cirno");
        touhou.add("Lumia");
        touhou.add("Sanae");
        touhou.add("Youmu");
        touhou.add("Leise");

        msd(touhou);
        System.out.println(touhou);
    }
}
