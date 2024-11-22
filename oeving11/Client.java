package oeving11;
import java.util.Scanner;

/**
 * The Client class provides an interactive console-based user interface 
 * for managing a property register. Users can add new properties, search by 
 * location or lot number, calculate the average area of properties, and list 
 * all registered properties.
 * 
 * The program runs in a loop, allowing the user to perform various operations 
 * until they choose to quit.
 */

public class Client {
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Generates a pre-populated PropertyRegister with sample data.
     * 
     * @return A PropertyRegister instance containing sample properties.
     */

    private static PropertyRegister generatePropertyRegister() {
        PropertyRegister propertyRegister = new PropertyRegister();
        propertyRegister.addProperty("Gloppen", 1445, 77, 631, " ", 1017.6, "Jens Olsen" );
        propertyRegister.addProperty("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        propertyRegister.addProperty("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen" );
        propertyRegister.addProperty("Gloppen", 1445, 74, 188, " ", 1457.2, "Karl Ove Braaten");
        propertyRegister.addProperty("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregaard");
        return propertyRegister;
    }

     /**
     * Prompts the user to enter a valid integer value. 
     * If the input is invalid, the user is then asked to try again.
     * 
     * @param message The message displayed to the user.
     * @return A valid integer entered by the user.
     */

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

    /**
     * Prompts the user to enter a valid double value.
     * If the input is invalid, the user is asked to try again.
     * 
     * @param message The message displayed to the user.
     * @return A valid double entered by the user.
     */

    private static double getValidDouble(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid long :)");
            }
        }
    }

    /**
     * Prompts the user to enter a non-empty string.
     * If the input is empty, the user is asked to try again.
     * 
     * @param message The message displayed to the user.
     * @return A non-empty string entered by the user.
     */

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

    /**
     * Displays a menu of options and prompts the user to pick one.
     * 
     * @return The user's chosen option as an integer.
     */

    private static int pickOption() {
        return getValidInt("Pick an option:\n"
                + "1. Add new property\n"
                + "2. Search by location\n"
                + "3. Search by lot number\n"
                + "4. Get average area\n"
                + "5. List all properties\n"
                + "6. Quit");
    }

    /**
     * Adds a new property to the PropertyRegister.
     * 
     * @param propertyRegister The PropertyRegister instance to which the property will be added.
     */

    private static void addProperty(PropertyRegister propertyRegister) {
        String municipalityName = getNonEmptyString("Please enter municipality's name:");
        int municipalityNumber = getValidInt("Please enter municipality's id:");
        int lotNumber = getValidInt("Please enter lot number:");
        int sectionNumber = getValidInt("Please enter section number:");
        String propertyName = getNonEmptyString("Please enter property's name:");
        double area = getValidDouble("Please enter property's area:");        
        String ownerName = getNonEmptyString("Please enter owner's name:");
        propertyRegister.addProperty(municipalityName, municipalityNumber, lotNumber, sectionNumber, propertyName, area, ownerName);
    }

     /**
     * Searches for properties at a specified location in the PropertyRegister.
     * 
     * @param propertyRegister The PropertyRegister instance to search.
     */

    private static void getPropertiesAtLocation(PropertyRegister propertyRegister) {
        String location = getNonEmptyString("Please enter location (Municipality number-lot number/section number) :");
        propertyRegister.getPropertiesAtLocation(location).stream().forEach(property -> System.out.println(property + "\n"));
    }

    /**
     * Searches for properties by lot number in the PropertyRegister.
     * 
     * @param propertyRegister The PropertyRegister instance to search.
     */

    private static void getPropertiesAtLotNumber(PropertyRegister propertyRegister) {
        int lotNumber = getValidInt("Please enter lot number:");
        propertyRegister.getPropertiesAtLotNumber(lotNumber).stream().forEach(property -> System.out.println(property + "\n"));
    }

    /**
     * Calculates and returns the average area of all properties in the {@link PropertyRegister}.
     * 
     * @param propertyRegister The PropertyRegister instance containing the properties.
     * @return The average area of all properties.
     */

    private static double getAverageArea(PropertyRegister propertyRegister) {
        return propertyRegister.getAverageArea();
    }

    /**
     * Prints all properties in the PropertyRegister.
     * 
     * @param propertyRegister The PropertyRegister instance containing the properties.
     */

    private static void printAllProperties(PropertyRegister propertyRegister) {
        propertyRegister.printAllProperties();
    }

     /**
     * Provides the main interaction loop for the user to interact with the 
     * PropertyRegister. This method allows the user to perform various 
     * operations such as adding a property, searching by location or lot number, 
     * getting the average area, and listing all properties.
     * 
     * The method runs in a continuous loop, presenting a menu of options to the user 
     * and executing the corresponding functionality based on the user's choice. 
     * The loop terminates when the user selects the "Quit" option.
     * 
     * Options:
     * <ol>
     *   <li>Add new property</li>
     *   <li>Search by location</li>
     *   <li>Search by lot number</li>
     *   <li>Get average area</li>
     *   <li>List all properties</li>
     *   <li>Quit</li>
     * </ol>
     * @param propertyRegister The PropertyRegister instance that the user interacts with.
    */

    private static void client(PropertyRegister propertyRegister) {
        while (true) {
            int option = pickOption();
            switch (option) {
                case 1 -> {
                    addProperty(propertyRegister);
                }
                case 2 -> {
                    getPropertiesAtLocation(propertyRegister);
                }   
                case 3 -> {
                    getPropertiesAtLotNumber(propertyRegister);
                }  
                case 4 -> {
                    double averageArea = getAverageArea(propertyRegister);
                    System.out.printf("The average area of all properties is: %.2f m²%n", averageArea);
                }
                case 5 -> {
                    printAllProperties(propertyRegister);
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
    
     /**
     * The entry point of the program. Initializes the PropertyRegister
     * and starts the client interaction loop.
     * 
     * @param args Command-line arguments (not used).
     */
    
    public static void main(String[] args) {
        PropertyRegister propertyRegister = generatePropertyRegister();
        client(propertyRegister);
        scanner.close();
    }
}
