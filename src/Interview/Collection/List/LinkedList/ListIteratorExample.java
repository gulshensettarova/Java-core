package Interview.Collection.List.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // ListIterator yaradılır
        ListIterator<String> iterator = list.listIterator();

        //hasNext() ve next()
        while (iterator.hasNext()) {
            System.out.println("Element movcuddur: "+iterator.next());
        }

        //hasPrevious() ve previous()
        if(iterator.hasPrevious()) {
            System.out.println("Evvelki element: "+iterator.previous());
        }

        //nextIndex() ve prevoiusIndex()
        System.out.println("Növbəti indeks: " + iterator.nextIndex());
        iterator.next();
        System.out.println("Növbəti indeks: " + iterator.nextIndex());
        iterator.previous();
        iterator.previous();
        System.out.println("Əvvəlki indeks: " + iterator.previousIndex());
        iterator.previous();
        System.out.println("Əvvəlki indeks: " + iterator.previousIndex());


        //remove()- remove() metodu yalnız sonuncu çağırılmış element üzərində işləyir.
                    // Bu o deməkdir ki, sonuncu dəfə next() və ya previous() metodlarından hansı birini çağırmısansa, remove() həmin metodun qaytardığı elementi silir.
        iterator.remove();


        //set(E e)
        LinkedList<String> languages = new LinkedList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        ListIterator<String> listIterator = languages.listIterator();

        // ikinci elementi oxuyuruq
        listIterator.next(); // Java
        listIterator.next(); // Python

        // Python elementini yeni dəyərlə əvəz edirik
        listIterator.set("Kotlin");
        System.out.println("Dəyişikliklərdən sonra LinkedList: " + languages);
        //output :[Java, Kotlin, C++]

        //add(E e)

        LinkedList<String> professions = new LinkedList<>();
        professions.add("Backend developer");
        professions.add("Frontend developer");

        ListIterator<String> professionIterator = professions.listIterator();

        // İlk elementi oxuyuruq
        professionIterator.next(); // Backend developer

        // Yeni element əlavə edirik
        professionIterator.add("QA Tester");

        System.out.println("Dəyişikliklərdən sonra LinkedList: " + professions);
        //output : [Backend developer, QA Tester, Frontend developer]
    }
}
