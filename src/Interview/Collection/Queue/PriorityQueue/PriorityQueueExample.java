package Interview.Collection.Queue.PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        class Task implements  Comparable<Task>{
            String name;
            int priority;

            Task(String name,int priority){
                this.name=name;
                this.priority=priority;
            }

            @Override
            public int compareTo(Task other) {
                return Integer.compare(this.priority,other.priority);
            }
            @Override
            public String toString() {
                return name + " (Prioritet: " + priority + ")";
            }
        }

        PriorityQueue<Task> queue =new PriorityQueue<>();
        queue.add(new Task("Təhlükəsizlik sistemini yoxla", 3));
        queue.add(new Task("API-ları yaz", 4));
        queue.add(new Task("Arxitekturanı qur", 2));
        queue.add(new Task("Texniki tapşırığı yoxla", 1));

        System.out.println("Prioritetli işlər:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
