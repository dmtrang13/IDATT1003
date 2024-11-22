package oeving10.eventManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EventManager {
    private ArrayList<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }

    public int eventCount() {
        return this.events.size();
    }

    public void addEvent(String name, String location, String organiser, String type, long dateTime) {
        this.events.add(new Event(eventCount(), name, location, organiser, type, dateTime));
    }

    public ArrayList<Event> getEventsAtLocation(String location) {
        return events.stream().filter(event -> event.getLocation().equals(location))
        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Event> getEventsAtDate(int date) {
        return events.stream().filter(event -> event.getDate() == date)
        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Event> getEventsBetweenDates(int start, int end) {
        return events.stream().filter(event -> event.getDate() >= start && event.getDate() <= end)
        .sorted(Comparator.comparingLong(Event::getDateTime))
        .collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Event> getEventsSorted(Comparator<Event> comparator) {
        return events.stream().sorted(comparator)
        .collect(Collectors.toCollection(ArrayList::new));
    }
}
