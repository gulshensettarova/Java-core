package Interview.Collection.Set.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // 1. TreeSet yaratmaq və elementlər əlavə etmək
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Mango");

        // TreeSet-i çap etmək (Sıralanmış qaydada)
        System.out.println("TreeSet elementləri: " + treeSet);

        // 2. Elementin olub-olmadığını yoxlamaq (contains)
        System.out.println("TreeSet-də 'Apple' var: " + treeSet.contains("Apple"));
        System.out.println("TreeSet-də 'Grapes' var: " + treeSet.contains("Grapes"));

        // 3. Elementi silmək (remove)
        treeSet.remove("Banana");
        System.out.println("Banana silindikdən sonra TreeSet: " + treeSet);

        // 4. Minimum və Maksimum elementləri tapmaq (first və last)
        TreeSet<Integer> numberSet = new TreeSet<>();
        numberSet.add(10);
        numberSet.add(5);
        numberSet.add(20);
        numberSet.add(1);

        System.out.println("Ən kiçik element: " + numberSet.first());
        System.out.println("Ən böyük element: " + numberSet.last());

        // 5. Verilmiş elementdən böyük və kiçik elementləri tapmaq (higher və lower)
        System.out.println("10-dan böyük element: " + numberSet.higher(10));
        System.out.println("10-dan kiçik element: " + numberSet.lower(10));

        // 6. Ən kiçik və ən böyük elementləri silmək (pollFirst və pollLast)
        System.out.println("Ən kiçik element çıxarıldı: " + numberSet.pollFirst());
        System.out.println("Qalan elementlər: " + numberSet);
        System.out.println("Ən böyük element çıxarıldı: " + numberSet.pollLast());
        System.out.println("Qalan elementlər: " + numberSet);

        // 7. TreeSet-də iterator vasitəsilə iterasiya etmək
        System.out.print("TreeSet elementləri (iterator ilə): ");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 8. TreeSet-in ölçüsünü yoxlamaq (size)
        System.out.println("TreeSet-də elementlərin sayı: " + treeSet.size());

        // 9. TreeSet-in boş olub-olmadığını yoxlamaq (isEmpty)
        System.out.println("TreeSet boşdur: " + treeSet.isEmpty());
    }
}
