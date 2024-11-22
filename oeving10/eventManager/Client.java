package oeving10.eventManager;
import java.util.Comparator;
import java.util.Scanner;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static EventManager generateEventManager() {
        EventManager eventManager = new EventManager();
        eventManager.addEvent("Blahaj Shopping", "IKEA Leangen", "none", "shopping",  202411111703L);
        eventManager.addEvent("Spillexpo", "Lillestrøm", "Spillexpo", "convention",  202410011100L);
        eventManager.addEvent("The Culture Feast", "Oslo Katedralskole", "IK", "charity",  202401101415L);
        eventManager.addEvent("Kattarock", "Oslo Katedralskole", "Kattarock", "concert",  202401271430L);
        return eventManager;
    }

    private static int getValidInt(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine(); 
            try {   
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer :) ");
            }
        }
    }

    private static long getValidLong(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid long :)");
            }
        }
    }

    private static String getNonEmptyString(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please enter a valid string :)");
            } else {
                return input;
            }
        }
    }

    private static int pickOption() {
        return getValidInt("Pick an option:\n"
                + "1. Add new event\n"
                + "2. Search by location\n"
                + "3. Search by date\n"
                + "4. Serch between two dates\n"
                + "5. List all events\n"
                + "6. Quit");
    }

    private static void addEvent(EventManager eventManager) {
        String name = getNonEmptyString("Please enter event's name:");
        String location = getNonEmptyString("Please enter event's location:");
        String organiser = getNonEmptyString("Please enter event's organiser:");
        String type = getNonEmptyString("Please enter event's type:");
        long dateTime = getValidLong("Please enter event's date time:");
        eventManager.addEvent(name, location, organiser, type, dateTime);
    }

    private static void getEventsAtLocation(EventManager eventManager) {
        String location = getNonEmptyString("Please enter location:");
        eventManager.getEventsAtLocation(location).stream().forEach(event -> System.out.println(event + "\n"));
    }

    private static void getEventsAtDate(EventManager eventManager) {
        int date = getValidInt("Please enter date:");
        eventManager.getEventsAtDate(date).stream().forEach(event -> System.out.println(event + "\n"));
    }

    private static void getEventsBetweenDates(EventManager eventManager) {
        int start = getValidInt("Please enter start date:");
        int end = getValidInt("Please enter end date:");
        eventManager.getEventsBetweenDates(start, end).stream().forEach(event -> System.out.println(event + "\n"));
    }

    private static void getEventsSorted(EventManager eventManager) {
        System.out.println("List of events sorted by location:");
        eventManager.getEventsSorted(Comparator.comparing(Event::getLocation))
                .stream().forEach(event -> System.out.println(event + "\n"));
        System.out.println("List of events sorted by type:");
        eventManager.getEventsSorted(Comparator.comparing(Event::getType))
                .stream().forEach(event -> System.out.println(event + "\n"));
        System.out.println("List of events sorted by date time:");
        eventManager.getEventsSorted(Comparator.comparingLong(Event::getDateTime))
                .stream().forEach(event -> System.out.println(event + "\n"));            
    }

    private static void client(EventManager eventManager) {
        while (true) {
            System.out.println(eventManager.eventCount());
            int option = pickOption();
            switch (option) {
                case 1 -> {
                    addEvent(eventManager);
                }
                case 2 -> {
                    getEventsAtLocation(eventManager);
                }   
                case 3 -> {
                    getEventsAtDate(eventManager);
                }  
                case 4 -> {
                    getEventsBetweenDates(eventManager);
                }
                case 5 -> {
                    getEventsSorted(eventManager);
                }  
                case 6 -> {
                    return;
                }             
                default -> {
                    System.out.println("Invalid option :C");
                }
            }
        }

    }
    
    
    
    public static void main(String[] args) {
        EventManager eventManager = generateEventManager();
        client(eventManager);
        scanner.close();
    }
}
