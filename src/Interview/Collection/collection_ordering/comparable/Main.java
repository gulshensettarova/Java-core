package Interview.Collection.collection_ordering.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(20));
        students.add(new Student(18));
        students.add(new Student(22));

        Collections.sort(students);
    }
}
