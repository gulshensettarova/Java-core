package Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    public static void main(String[] args) {
        // Tələbə ballarını saxlayan Map yaradın
        Map<String, Integer> studentGrades = new HashMap<>();

        // Tələbələrin ballarını əlavə edin
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);

        // Bir tələbənin ballarını əldə edin
        int bobGrade = studentGrades.get("Bob");
        System.out.println("Bob's grade: " + bobGrade);

        // Bütün tələbə ballarını göstərin
        System.out.println("Student grades:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
