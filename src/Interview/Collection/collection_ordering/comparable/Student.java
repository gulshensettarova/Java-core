package Interview.Collection.collection_ordering.comparable;

class Student implements Comparable<Student> {
    int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age;  // yaşa görə sıralama
    }
}