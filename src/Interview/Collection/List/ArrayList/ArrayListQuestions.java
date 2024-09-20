package Interview.Collection.List.ArrayList;

import java.util.*;

//for interview
public class ArrayListQuestions {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//Sual-1: ArrayList-in təkrarlanan dəyərləri necə silmək olar?
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(40);
        list.add(40);
        Set<Integer> set=new HashSet<>(list);  //HashSet dublicat data qebul etmir deye ondan istifade edirik
        list.clear();
        list.addAll(set);
//---------------------------------------------------------------------------------------------

//Sual-2:ArrayList-də elementləri tərsinə çevirmək necə olar?
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Collections.reverse(list1);

//---------------------------------------------------------------------------------------------

//Sual-3 :ArrayList-də null dəyərlər necə idarə edilir?
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java");
        list2.add(null); //ArrayList-e null deyer elave etmek mumkundur
        list2.add("Programming");
        list2.add(null);
        list2.add("Spring");
        list2.add("Postgre");
        list2.add("Oracle");
        list2.add("Hibernate");
        list2.add("RabbitMQ");
        list2.add("Redis");

        System.out.println("ArrayList: " + list);
//      output:ArrayList: [Java, null, Programming, null]


        Comparator<String> nullSafeComparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1==null && o2==null) return 0;
                if(o1==null) return -1;
                if(o2==null) return 1;
                return o1.compareTo(o2);
            }
        };
        Collections.sort(list2,nullSafeComparator);
        System.out.println("Sorted List: " + list2);
// output : Sorted List: [null, null, Apple, Banana, Cherry, Mango]


    }



}
