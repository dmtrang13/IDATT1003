package oeving11;
import java.util.ArrayList;
import java.util.stream.Collectors;

 /**
 * The PropertyRegister class provides functionality to manage a collection 
 * of Property objects. It allows adding new properties, retrieving properties 
 * based on location or lot number, calculating the average area, and printing all 
 * registered properties.
 * 
 * This class acts as a central repository for managing property-related data.
 */

public class PropertyRegister {
    private ArrayList<Property> properties;

     /**
     * Constructs an empty PropertyRegister.
     */

    public PropertyRegister() {
        this.properties = new ArrayList<>();
    }

     /**
     * Retrieves all properties in the register.
     * 
     * @return An ArrayList containing all registered properties.
     */

    public ArrayList<Property> getProperties() {
        return this.properties;
    }

     /**
     * Adds a new property to the register.
     * 
     * @param municipalityName The name of the municipality.
     * @param municipalityNumber The unique ID of the municipality.
     * @param lotNumber The lot number of the property.
     * @param sectionNumber The section number of the property.
     * @param propertyName The name of the property.
     * @param area The area of the property in square meters.
     * @param ownerName The name of the property's owner.
     */

    public void addProperty(String municipalityName, int municipalityNumber, int lotNumber, int sectionNumber, String propertyName, double area, String ownerName) {
        this.properties.add(new Property(municipalityName, municipalityNumber, lotNumber, sectionNumber, propertyName, area, ownerName));
    }

     /**
     * Retrieves a list of properties located at the specified location.
     * The location is specified in the format {municipalityNumber-lotNumber/sectionNumber}.
     * 
     * @param location The location string in the format {municipalityNumber-lotNumber/sectionNumber}.
     * @return An {ArrayList} containing all properties at the specified location.
     */

    public ArrayList<Property> getPropertiesAtLocation(String location) {
        return properties.stream().filter(property -> property.getLocation().equals(location))
        .collect(Collectors.toCollection(ArrayList::new));
    }

     /**
     * Retrieves a list of properties with the specified lot number.
     * 
     * @param lotNumber The lot number to search for.
     * @return An ArrayList containing all properties with the specified lot number.
     */

    public ArrayList<Property> getPropertiesAtLotNumber(int lotNumber) {
        return properties.stream().filter(property -> property.getLotNumber() == lotNumber)
        .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Calculates the average area of all properties in the register.
     *
     * @return The average area of all properties.
     * @throws IllegalStateException if there are no properties in the register.
     */

    public double getAverageArea() {
        if (properties.isEmpty()) {
            System.out.println("No properties registered.");
            return 0; 
        }
        double totalArea = 0;
        for (Property property : properties) {
            totalArea += property.getArea();
        }
        return totalArea / properties.size();
    }

    /**
     * Prints all properties in the register. If there are no properties, 
     * a message indicating that the register is empty is displayed.
     */

    public void printAllProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties registered.");
        } else {
            System.out.println("List of properties:");
            for (Property property : properties) {
                System.out.println(property); // Calls the toString() method
            }
        }
    }
}
