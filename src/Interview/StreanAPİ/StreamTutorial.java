package Interview.StreanAPİ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTutorial {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(17,11,99,1,6,96,28,10,23,28);
       //Example-1 ---Cut ededlerin her birini 10 vahid artiraq
        // Source, intermediate operations, and terminal operation
        List<Integer> result = numbers.stream() // source
                .filter(x -> x % 2 == 0)      // filter even numbers
                .distinct()                   // remove duplicates
                .map(x -> x + 10)             // add 10 to each number
                .collect(Collectors.toList()); // collect the result into a List



        //Example-2 ---Cüt ədədlərin kvadratlarının cəmi
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)       // Cüt ədədləri seçirik
                .map(n -> n * n)              // Hər cüt ədədin kvadratını hesablayiriq
                .reduce(0, Integer::sum);      // Kvadratların cəmini tapiriq

        System.out.println("Cüt ədədlərin kvadratlarının cəmi: " + sumOfSquares);


        //Example-3 ---Uzunluğu 5-dən böyük unikal istifadəçi adlarının sayı

        List<String> usernames = Arrays.asList("user1", "admin", "superuser", "guest", "admin");

        long countLongUsernames = usernames.stream()
                .distinct()                       // Unikal istifadəçi adları
                .filter(username -> username.length() > 5)  // Uzunluğu 5-dən böyük olanları seçirik
                .count();                        // Sayını tapiriq

        System.out.println("Uzunluğu 5-dən böyük unikal istifadəçi adlarının sayı: " + countLongUsernames);


        //Example-4 ---Cüt ədədlərin ədədi ortası

        double averageOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)       // Cüt ədədləri seçiriq
                .mapToInt(n -> n)              // int stream-ə çeviririk
                .average()                      // Orta qiyməti hesablayiriq
                .orElse(0.0);                  // Heç bir cüt ədəd yoxdursa 0 döndərir



        //Peek- ə aid nümunə :
        numbers.stream()
                .filter(n -> n % 2 == 0) // Cüt ədədləri seç
                .peek(n -> System.out.println("Cüt ədəd: " + n)) // Elementləri izləyir
                .map(n -> n * 2) // Cüt ədədləri iki qat artır
                .forEach(n -> System.out.println("İki qat artırılmış: " + n)); // Nəticəni çap edir

    }
}
