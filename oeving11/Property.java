package oeving11;


/**
 * This class represents a property with details about its location, size, and owner.
 */

public class Property {
    private String municipalityName;
    private int municipalityNumber;
    private int lotNumber;
    private int sectionNumber;
    private String propertyName;
    private double area;
    private String ownerName;

    /**
     * Constructor to initialize a Property object.
     *
     * @param municipalityName Name of the municipality.
     * @param municipalityNumber ID of the municipality.
     * @param lotNumber Lot number of the property.
     * @param sectionNumber Section number of the property.
     * @param propertyName Name of the property.
     * @param area Area of the property in square meters.
     * @param ownerName Name of the property's owner.
     */

    public Property(String municipalityName, int municipalityNumber, int lotNumber, int sectionNumber, String propertyName, double area, String ownerName) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.propertyName = propertyName;
        this.area = area;
        this.ownerName = ownerName;
    }

    /**
     * Gets the municipality name.
     *
     * @return Name of the municipality.
     */

    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Gets the property's location in the format "municipalityNumber-lotNumber/sectionNumber".
     *
     * @return Formatted location string.
     */

    public String getLocation() {
        String location = String.format("%d-%d/%d", municipalityNumber, lotNumber, sectionNumber); 
        return location;
    }

    /**
     * Gets the lot number.
     *
     * @return Number of the lot.
     */

    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * Gets the property name.
     *
     * @return Name of the property.
     */

    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Gets the area of the property.
     *
     * @return Area of the property.
     */
    public double getArea() {
        return area;
    }

    /**
     * Gets the owner name.
     *
     * @return Name of the owner.
     */

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Returns a string representation of the property, including municipality details,
     * property name, area, and owner.
     *
     * @return A formatted string containing property details.
     */

    @Override
    public String toString() {
        return "Municipality: " + municipalityName
            + "\nID: " + municipalityNumber 
            + "-" + lotNumber
            + "/ " + sectionNumber
            + "\nProperty name: " + propertyName
            + "\nArea: " + area
            + "\nOwner: " + ownerName
            + "\n";
    }
}


