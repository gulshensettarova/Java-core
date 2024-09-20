package Interview.Map;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        // Söz sayımı üçün Interview.Map yaradın
        Map<String, Integer> wordCount = new HashMap<>();

        // Mətnin içindəki sözlər
        String text = "hello world hello java world java";
        String[] words = text.split(" ");

        // Sözlərin sayını artırın
        //wordCount.getOrDefault(word, 0) metodu istifadə edərək,
        // əgər wordCount map-də həmin sözü taparsa, onun cari sayını alır, əks halda 0 qaytarır.
        //wordCount.put(word, wordCount.getOrDefault(word, 0) + 1) ilə həmin sözün sayını 1 artıraraq
        // Interview.Map-ə yerləşdirir. Əgər həmin söz əvvəllər map-də varsa, onun sayı artırılır;
        // yoxdursa, yeni açar-dəyər cütü əlavə edilir.
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Sözlərin sayını göstərin
        System.out.println("Word count:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
