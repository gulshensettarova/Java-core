package Interview.functional_interface;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class StandartInteface {
    public static void main(String[] args) {
        //Java 8-dən sonra gələn functional interface-ləri nəzərdən keçirək:

        //1) Function<T, R> --- T tipinde arqument qebul edib, R tipinde arqument qaytarir.
        // (apply)
        System.out.println("--------------Function-------------------------------");

        Function<String, Integer> fun = s-> s.length();
        System.out.println("s-> s.length(): "+fun.apply("Gulshan"));

        //Basqa bir numuneye baxaq :
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println("x -> x * x: "+squareFunction.apply(5));

        /*Java-da Function interfeysi iki funksiyanı birləşdirmək üçün compose və andThen metodlarına malikdir.
        compose: Birinci funksiyanı ikinci funksiyadan əvvəl tətbiq edir.
        andThen: Birinci funksiyadan sonra ikinci funksiyanı tətbiq edir.*/
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addThree = x -> x + 3;

        // Əvvəlcə 2-ə vurur, sonra isə 3 əlavə edir
        Function<Integer, Integer> combination1 =multiplyByTwo.andThen(addThree);
        System.out.println("multiplyByTwo.andThen(addThree): "+combination1.apply(5));

        // Əvvəlcə 3 əlavə edir, sonra 2-ə vurur
        Function<Integer,Integer> combination2 =multiplyByTwo.compose(addThree);
        System.out.println("multiplyByTwo.compose(addThree): "+combination2.apply(5));



        //2)  Predicate<T> Bu interfeys bir T tipli arqument qəbul edir və bu arqumentin müəyyən bir şərti ödəniş edib-etmədiyini boolean olaraq qaytarır.
        // (test)
        System.out.println();
        System.out.println("--------------Predicate-------------------------------");

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));  // Çıxış: true

        //Stream uzerinden bir numuneye baxaq:
        Predicate<Integer> isOdd = x -> x % 2 != 0;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> oddNumbers=numbers.stream()
                                        .filter(isOdd)//bura hazir filter gonnderirik
                                        .collect(Collectors.toList());

        //Predicate<T> interfeysi ardıcıl şərtlər yaratmaq üçün and, or, və negate metodlarına malikdir.

        Predicate<Integer> positiveNumber = x -> x > 0;
        Predicate<Integer> evenNumber = x -> x % 2 == 0;
        Predicate<Integer> isPositiveAndEven=positiveNumber.and(evenNumber);
        System.out.println("positiveNumber.and(evenNumber): "+isPositiveAndEven.test(5));
        Predicate<Integer> isPositiveOrEven = positiveNumber.or(evenNumber);
        System.out.println("positiveNumber.or(evenNumber): "+isPositiveOrEven.test(5));


        //3)Consumer<T> T tipli arqument qəbul edərək müəyyən bir əməliyyat icra edir, lakin heç bir dəyər qaytarmır (void qaytarır).
        //accept(T t)
        System.out.println();
        System.out.println("--------------Consumer-------------------------------");
        Consumer<String> print = s -> System.out.println(s);

        print.accept("Hello World!");  // Çıxış: Hello World!

        //Basqa bir numuneye baxaq :
        List<Integer> num = List.of(1, 2, 3, 4, 5);

        Consumer<Integer> addAndPrint = n -> System.out.println(n + 2);

        numbers.forEach(addAndPrint);  // Çıxış: 3, 4, 5, 6, 7

        //Consumer<T> interfeysi andThen metoduna malikdir ki, bu da birdən çox əməliyyatı ardıcıl icra etməyə imkan verir.
        Consumer<String> printString = s -> System.out.println("Printing: " + s);
        Consumer<String> printUpperCase = s -> System.out.println("Upper case: " + s.toUpperCase());
        Consumer<String> combined = printString.andThen(printUpperCase);

        combined.accept("hello");


        //4) Supplier<T> -- heç bir arqument almadan T tipinde bir netice qaytrir
        //get()
        System.out.println();
        System.out.println("--------------Supplier-------------------------------");
        //Random qiymet qaytaran
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println(randomSupplier.get());

        //Cari vaxti qaytaran
        Supplier<String> timeSupplier = () -> LocalTime.now().toString();
        System.out.println("Current time: " + timeSupplier.get());

        //5) BiFunction<T, U, R> -- T ve U tiplerinde 2 arqument qebul edir ve R tipinde bir netice qaytarir
        //apply(T t, U u)
        System.out.println();
        System.out.println("--------------BiFunction-------------------------------");
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20));  // Çıxış: 30
        System.out.println(sum.apply(5, 7));    // Çıxış: 12

    }
}
