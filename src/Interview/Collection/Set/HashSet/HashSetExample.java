package Interview.Collection.Set.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // HashSet yaradılması
        Set<String> set = new HashSet<>();

        // 1. Elementlərin əlavə edilməsi
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Eyni element təkrar əlavə edilir
        System.err.println(set);
        // 2. Elementlərin yoxlanılması
        boolean hasApple = set.contains("Apple"); // true
        boolean hasGrape = set.contains("Grape"); // false

        System.out.println("Contains Apple: " + hasApple);
        System.out.println("Contains Grape: " + hasGrape);

        // 3. Elementlərin silinməsi
        set.remove("Banana"); // Banana silinir

        // 4. Elementlərin sayı
        int size = set.size(); // 2, çünki "Banana" silinib

        System.out.println("Size of the set: " + size);

        // 5. Bütün elementlərin silinməsi
        set.clear(); // Set-dəki bütün elementlər silinir

        // 6. Set-in boş olub-olmadığını yoxlama
        boolean isEmpty = set.isEmpty(); // true, çünki bütün elementlər silinib

        System.out.println("Is the set empty? " + isEmpty);

        // 7. Elementlər üzərində iterasiya
        // Yenidən elementlər əlavə edək
        set.add("Orange");
        set.add("Grapes");

        System.out.println("Elements in the set:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 8. Set-in üzərində foreach döngüsü ilə iterasiya
        System.out.println("Elements using foreach:");
        set.forEach(element -> System.out.println(element));

        // 9. Set-in `toArray` metodundan istifadə
        Object[] array = set.toArray(); // Set-dəki elementləri massivə çevirir
        System.out.println("Elements in array:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // 10. `retainAll` və `removeAll` metodları
        Set<String> anotherSet = new HashSet<>();
        anotherSet.add("Orange");
        anotherSet.add("Apple");

        // `retainAll` metodundan istifadə edərək ortaq elementləri saxlayırıq
        set.retainAll(anotherSet); // "Apple" və "Orange" saxlanılır

        System.out.println("Elements after retainAll:");
        set.forEach(System.out::println);

        // `removeAll` metodundan istifadə edərək müəyyən elementləri silirik
        set.removeAll(anotherSet); // "Apple" və "Orange" silinir

        System.out.println("Elements after removeAll:");
        set.forEach(System.out::println);
    }
}
