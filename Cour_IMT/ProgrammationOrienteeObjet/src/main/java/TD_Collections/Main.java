package TD_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("AHA","BOC","KLI"));
        System.out.println(arrayList1);

        arrayList1.add(1,"XXX");
        System.out.println(arrayList1);
        arrayList1.remove(2);
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("AHA", "XXX", "CCC"));
        System.out.println(arrayList1.containsAll(arrayList2));

        arrayList1.retainAll(arrayList2);
        System.out.println(arrayList1);

        System.out.println("****************************************");

        LinkedList<String> linkedList1 = new LinkedList<>(Arrays.asList("AHA","BOC","KLI"));
        System.out.println(linkedList1);

        linkedList1.add(1,"XXX");
        System.out.println(linkedList1);
        linkedList1.remove(2);
        System.out.println(linkedList1);

        LinkedList<String> linkedList2 = new LinkedList<>(Arrays.asList("AHA", "XXX", "CCC"));
        System.out.println(linkedList1.containsAll(arrayList2));

        linkedList1.retainAll(linkedList2);
        System.out.println(linkedList1);

        System.out.println("****************************************");

        HashSet<String> hashSet1 = new HashSet<>(Arrays.asList("AHA","BOC","KLI"));
        System.out.println(hashSet1);

        hashSet1.add(null);
        System.out.println(hashSet1);
        hashSet1.remove("BOC");
        System.out.println(hashSet1);

        HashSet<String> hashSet2 = new HashSet<>(Arrays.asList("AHA", "XXX", "CCC"));
        System.out.println(hashSet2.containsAll(hashSet1));

        hashSet1.retainAll(hashSet2);
        System.out.println(hashSet1);

    }
}
