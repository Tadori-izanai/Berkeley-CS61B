package examprep12;

import java.util.ArrayList;
import java.util.Collections;

public class BearsAndBeds {
    /** clear the target, and catenate l1, l2, l3 together into target */
    private static <Item> void clearAndCat(
            ArrayList<Item> target, ArrayList<Item> l1, ArrayList<Item> l2, ArrayList<Item> l3
    ) {
        target.clear();
        target.addAll(l1);
        target.addAll(l2);
        target.addAll(l3);
    }

    private static void quickSort(ArrayList<Bear> a, ArrayList<Bed> b) {
        if (a.size() <= 1) {
            return;
        }
        Bear pivotBear = a.get(0);
        Bed pivotBed = null;
        for (Bed bed : b) {
            if (pivotBear.compareToBed(bed) == 0) {
                pivotBed = bed;
                break;
            }
        }
        assert pivotBed != null;

        ArrayList<Bear> smallBears = new ArrayList<>();
        ArrayList<Bear> midBears = new ArrayList<>();
        ArrayList<Bear> bigBears = new ArrayList<>();
        ArrayList<Bed> smallBeds = new ArrayList<>();
        ArrayList<Bed> midBeds = new ArrayList<>();
        ArrayList<Bed> bigBeds = new ArrayList<>();

        for (Bear bear : a) {
            if (bear.compareToBed(pivotBed) > 0) {
                bigBears.add(bear);
            } else if (bear.compareToBed(pivotBed) < 0) {
                smallBears.add(bear);
            } else {
                midBears.add(bear);
            }
        }

        for (Bed bed : b) {
            if (pivotBear.compareToBed(bed) > 0) {
                smallBeds.add(bed);
            } else if (pivotBear.compareToBed(bed) < 0) {
                bigBeds.add(bed);
            } else {
                midBeds.add(bed);
            }
        }

        quickSort(smallBears, smallBeds);
        quickSort(bigBears, bigBeds);

        clearAndCat(a, smallBears, midBears, bigBears);
        clearAndCat(b, smallBeds, midBeds, bigBeds);
    }


    public static void main(String[] args) {
        int n = 18;
        ArrayList<Bear> bears = new ArrayList<>();
        ArrayList<Bed> beds = new ArrayList<>();

        for (int i = 0 ; i < n; i += 1) {
            bears.add(new Bear(i));
            beds.add(new Bed(i));
        }
        Collections.shuffle(bears);
        Collections.shuffle(beds);

        System.out.println("Bears:");
        System.out.println(bears);
        System.out.println("Beds:");
        System.out.println(beds);

        quickSort(bears, beds);

        System.out.println("Bears:");
        System.out.println(bears);
        System.out.println("Beds:");
        System.out.println(beds);
    }
}
