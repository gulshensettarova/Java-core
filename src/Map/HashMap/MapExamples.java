package Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Map.Entry;

public class MapExamples {
    public static void main(String[] args) {
        // Map yarat
        Map<String, Integer> map = new HashMap<>();

        // 1. put(K key, V value) - Açar-Dəyər Cütü Əlavə Etmək
        map.put("Alice", 25);
        map.put("Bob", 30);
        System.out.println("After put(): " + map); // Output: {Alice=25, Bob=30}

        // 2. get(Object key) - Açar Üzrə Dəyəri Əldə Etmək
        Integer ageAlice = map.get("Alice");
        System.out.println("Alice's age: " + ageAlice); // Output: Alice's age: 25

        // 3. remove(Object key) - Açar-Dəyər Cütünü Silmək
        map.remove("Alice");
        System.out.println("After remove(): " + map); // Output: {Bob=30}

        // 4. containsKey(Object key) - Açarın Map-də Olub-Olmadığını Yoxlamaq
        boolean hasKeyBob = map.containsKey("Bob");
        System.out.println("Contains 'Bob': " + hasKeyBob); // Output: Contains 'Bob': true

        // 5. containsValue(Object value) - Dəyərin Map-də Olub-Olmadığını Yoxlamaq
        boolean hasValue30 = map.containsValue(30);
        System.out.println("Contains value 30: " + hasValue30); // Output: Contains value 30: true

        // 6. size() - Map-dəki Açar-Dəyər Cütlərinin Sayını Əldə Etmək
        int size = map.size();
        System.out.println("Map size: " + size); // Output: Map size: 1

        // 7. isEmpty() - Map-in Boş Olub-Olmadığını Yoxlamaq
        boolean isEmpty = map.isEmpty();
        System.out.println("Map is empty: " + isEmpty); // Output: Map is empty: false

        // 8. clear() - Map-dəki Bütün Açar-Dəyər Cütlərini Silmək
        map.clear();
        System.out.println("After clear(): " + map); // Output: {}

        // 9. keySet() - Map-dəki Açarları Almaq
        map.put("Alice", 25);
        map.put("Bob", 30);
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys); // Output: Keys: [Alice, Bob]

        // 10. values() - Map-dəki Dəyərləri Almaq
        Collection<Integer> values = map.values();
        System.out.println("Values: " + values); // Output: Values: [25, 30]

        // 11. entrySet() - Map-dəki Açar-Dəyər Cütlərini Almaq
        Set<Entry<String, Integer>> entries = map.entrySet();
        System.out.println("Entries:");
        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Output:
        // Entries:
        // Alice: 25
        // Bob: 30

        // 12. putAll(Map<? extends K, ? extends V> m) - Başqa Map-dəki Açar-Dəyər Cütlərini İndiki Map-ə Əlavə Etmək
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Charlie", 35);
        map2.put("Diana", 40);
        map.putAll(map2);
        System.out.println("After putAll(): " + map); // Output: {Alice=25, Bob=30, Charlie=35, Diana=40}

        // 13. replace(K key, V value) - Mövcud Açarın Dəyərini Dəyişdirmək
        map.replace("Alice", 26);
        System.out.println("After replace(): " + map); // Output: {Alice=26, Bob=30, Charlie=35, Diana=40}

        // 14. replace(K key, V oldValue, V newValue) - Mövcud Dəyəri Dəyişdirmək Əgər O Dəyər Məlum Açarla Uyğun Gəlirsə
        boolean replaced = map.replace("Bob", 30, 31);
        System.out.println("Replaced: " + replaced); // Output: Replaced: true
        System.out.println("After replaceIfMatch(): " + map); // Output: {Alice=26, Bob=31, Charlie=35, Diana=40}

        // 15. computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) - Əgər Açar Map-də Mövcud Deyilsə, Dəyəri Hesablayıb Əlavə Etmək
        map.computeIfAbsent("Eve", key -> key.length());
        map.computeIfAbsent("Charlie", key -> key.length()); // "Charlie" artıq mövcuddur, heç bir dəyişiklik etməz
        System.out.println("After computeIfAbsent(): " + map); // Output: {Alice=26, Bob=31, Charlie=35, Diana=40, Eve=3}
    }
}
