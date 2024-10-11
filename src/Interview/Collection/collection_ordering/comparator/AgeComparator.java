package Interview.Collection.collection_ordering.comparator;

import java.util.Comparator;

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();  // yaşa görə müqayisə
    }
}