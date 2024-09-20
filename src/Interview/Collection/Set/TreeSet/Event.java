package Interview.Collection.Set.TreeSet;

import java.time.LocalDate;

public class Event implements Comparable<Event> {
    private String name;
    private LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(Event other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return name + " - " + date;
    }}
