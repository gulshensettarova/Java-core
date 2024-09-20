package Interview.Collection.Set.TreeSet;

import java.time.LocalDate;
import java.util.TreeSet;

public class EventTreeSetExample {
    public static void main(String[] args) {
        TreeSet<Event> eventSet = new TreeSet<>();
        eventSet.add(new Event("Conference", LocalDate.of(2023, 4, 3)));
        eventSet.add(new Event("Workshop", LocalDate.of(2023, 10, 28)));
        eventSet.add(new Event("Seminar", LocalDate.of(2023, 3, 30)));

        System.out.println("Tarixə görə sıralanmış tədbirlər:");
        for (Event event : eventSet) {
            System.out.println(event);
        }

        // Müəyyən tarixdən sonrakı ilk tədbir
        Event upcomingEvent = eventSet.higher(new Event("", LocalDate.of(2023, 6, 1)));
        if (upcomingEvent != null) {
            System.out.println("6 iyundan sonrakı ilk tədbir: " + upcomingEvent);
        }
    }
}
