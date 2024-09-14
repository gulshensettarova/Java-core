package Collection.Queue.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // 1. Elementlərin əlavə olunması
        deque.addFirst("Java");  // Başa əlavə edir
        deque.addLast("Python"); // Sona əlavə edir
        deque.add("C++");        // Sona əlavə edir (addLast() ilə eyni)
        System.out.println("Elementlər əlavə olundu: " + deque);

        // 2. Elementlərin oxunması
        System.out.println("Başdakı element: " + deque.getFirst());
        System.out.println("Sondakı element: " + deque.getLast());

        // 3. Elementlərin oxunması (peek)
        System.out.println("Başdakı element (peekFirst): " + deque.peekFirst());
        System.out.println("Sondakı element (peekLast): " + deque.peekLast());

        // 4. Elementlərin silinməsi
        deque.removeFirst(); // Başı silir
        deque.removeLast();  // Sonu silir
        System.out.println("Baş və son elementlər silindi: " + deque);

        // 5. Elementlərin silinməsi (poll)
        deque.pollFirst(); // Başı silir
        deque.pollLast();  // Sonu silir (bura qədər hamısını sildik)
        System.out.println("Poll ilə elementlər silindi: " + deque);

        // 6. Stack kimi istifadə (LIFO)
        deque.push("HTML");
        deque.push("CSS");
        System.out.println("Stack kimi istifadə (LIFO): " + deque);
        System.out.println("Pop elementi: " + deque.pop()); // Başı silir (stack üçün pop)
        System.out.println("Stack-dən sonra vəziyyət: " + deque);

        // 7. Queue kimi istifadə (FIFO)
        deque.offer("NodeJS");
        deque.offer("ReactJS");
        System.out.println("Queue kimi istifadə (FIFO): " + deque);
        System.out.println("Poll elementi: " + deque.poll()); // Başı silir (queue üçün poll)
        System.out.println("Queue-dan sonra vəziyyət: " + deque);

        // 8. Boş və doluluq yoxlaması
        System.out.println("Deque boşdurmu? " + deque.isEmpty());

        // 9. Element sayı
        System.out.println("Deque-dəki element sayı: " + deque.size());

    }
}
