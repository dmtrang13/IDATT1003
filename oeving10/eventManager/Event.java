package oeving10.eventManager;

public class Event {
    private int id;
    private String name;
    private String location;
    private String organiser;
    private String type;
    private long dateTime;

    public Event(int id, String name, String location, String organiser, String type, long dateTime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organiser = organiser;
        this.type = type;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganiser() {
        return organiser;
    }

    public String getType() {
        return type;
    }

    public long getDateTime() {
        return dateTime;
    }

    public int getDate() {
        String dateTimeString = String.valueOf(dateTime);
        String date = dateTimeString.substring(0, 8);
        return Integer.parseInt(date);
    }

    @Override
    public String toString() {
        return "ID: " + id 
            + "\nName: " + name
            + "\nLocation: " + location
            + "\nOrganiser: " + organiser
            + "\nType: " + type
            + "\nDate and time: " + dateTime;
    }
    
}
