package Interview.Collection.collection_ordering.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", 20));
        students.add(new Student("B", 18));
        students.add(new Student("C", 22));

     // Yaşa görə sıralama
        Collections.sort(students, new AgeComparator());

      // Ada görə sıralama
        Collections.sort(students, new NameComparator());

    }

}
