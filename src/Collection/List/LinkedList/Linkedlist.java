package Collection.List.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

//for interview
public class Linkedlist {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("userTest");
        list.add("Mahammad");
        list.add("Gulshan");
        list.add("Sabina");

//   Sual-1 :     LinkedList Deque interfeysini implement edir. Deque interfeysinin funksionallıqlarından hansılar LinkedList-də mövcuddur?
//   Cavab-1:     LinkedList həm iki tərəfli növbə (deque) funksionallığı təmin edir, yəni elementləri həm əvvəlinə, həm də sonuna əlavə etmək və silmək mümkündür (addFirst(), addLast(), removeFirst(), removeLast() kimi metodlarla).
//                list.removeFirst();
//                list.removeLast();
//                list.remove(0);
//                list.addLast("TestUser");
//                list.addFirst("TestUser");

//---------------------------------------------------------------------------------------------
// Sual-2:      LinkedList sinfində first və last elementləri necə əldə edə bilərsən?
//Cavab-2:
            String firstElement = list.getFirst();
            String lastElement = list.getLast();

//---------------------------------------------------------------------------------------------
//Sual-3:     LinkedList-də middle elementini tapmaq üçün hansı optimal üsuldan istifadə etmək olar?
//Cavab-3:      two pointer technique istifade ede bilerik
        LinkedList<Integer> list1 = new LinkedList<>();

        // Siyahıya elementlər əlavə edək
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

        // Orta elementi tapmaq üçün Turtle and Hare üsulu
//        Integer middleElement = findMiddleElement(list1);
//        System.out.println("Question 3--> Middle element: " + middleElement);

//---------------------------------------------------------------------------------------------

//Sual-4:      Iterator ilə Keçid (Traversing)
//Cavab-4:
//        hasNext() — Siyahıda daha bir elementin olub-olmadığını yoxlayır. Əgər siyahıda hələ keçilməmiş element varsa, true qaytarır.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
//            next() — Növbəti elementi qaytarı
            String element = iterator.next();
            System.out.println("Question 4--> element: " + element);
        }


        LinkedList<String> list2 = new LinkedList<>();

        // Siyahıya elementlər əlavə edək
        list2.add("Element 1");
        list2.add("Element 2");
        list2.add("Element 3");
        list2.add("Element 4");


        // Iterator ilə travers edək və müəyyən şərt əsasında elementləri silək
        System.err.println("---------------Method remove()----------------");
        Iterator<String> iterator1 = list2.iterator();

        while (iterator1.hasNext()) {
            String element = iterator1.next();

            // Şərt: "Element 2" və "Element 4"-ü silək
            if (element.equals("Element 2") || element.equals("Element 4")) {
                iterator1.remove();  // Sonuncu next() ilə çağırılmış elementi silir
            }
        }
        // Yenidən siyahını çıxışa verək
        System.out.println("Siyahıdan sonra: " + list2);

//---------------------------------------------------------------------------------------------
//Sual-5: LinkedList-də necə dövrlü keçid (circular linked list) yarada bilərik?
//Cavab-5:
        CircularLinkedList list3 = new CircularLinkedList();

        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);

        list3.printList(); // Çıxış: 1 2 3 4
    }


//    İşləmə prinsipi: (Sual-3)
//    İlk olaraq, siyahı yaradılır və ona elementlər əlavə olunur.
//    Sonra, iki göstərici (slow və fast) LinkedList üzərində istifadə olunur.
//    Fast göstəricisi hər dəfə iki addım, slow isə bir addım irəliləyir.
//    Fast siyahının sonuna çatanda, slow orta elementi göstərir.
    public static Integer findMiddleElement(LinkedList<Integer> list) {
       var slowPointer=list.listIterator();
       var fastPointer=list.listIterator();
       while(fastPointer.hasNext()){
           fastPointer.next();
           if(fastPointer.hasNext()){
               fastPointer.next();
               slowPointer.next();
           }
       }
       return slowPointer.next();
    }
     }
