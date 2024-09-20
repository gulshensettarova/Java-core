package Interview.Collection.Set.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // LinkedHashSet yaratmaq
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 1. Elementlərin əlavə edilməsi
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Banana");  // Təkrar element, əlavə olunmayacaq
        System.out.println("Set elementi: " + set);

        // 2. Element silinməsi
        set.remove("Banana");
        System.out.println("Set elementi (Banana silindi): " + set);

        // 3. Elementin mövcudluğunu yoxlamaq
        boolean hasApple = set.contains("Apple");
        boolean hasOrange = set.contains("Orange");
        System.out.println("Setdə 'Apple' var: " + hasApple);
        System.out.println("Setdə 'Orange' var: " + hasOrange);

        // 4. Set-in boş olub-olmadığını yoxlamaq
        System.out.println("Set boşdur: " + set.isEmpty());

        // 5. Elementlərin sayını yoxlamaq
        System.out.println("Setdə elementlərin sayı: " + set.size());

        // 6. Elementlər üzərində iterasiya etmək
        System.out.print("Set elementləri (iterator ilə): ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 7. Set-i təmizləmək (clear)
        set.clear();
        System.out.println("Set təmizləndikdən sonra boşdur: " + set.isEmpty());
    }
}
