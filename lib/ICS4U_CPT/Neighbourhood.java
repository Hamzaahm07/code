package lib.ICS4U_CPT;

/**
 * author: Hamza Ahmed
 * date: 2025/01/15
 * Neighbourhoods in Toronto with stats; crime rate, average home price, andbtransit accessibility
 */

public class Neighbourhood {
    private String name;
    private double crimeRate; // Crime rate per 1,000 people in that neighbourhood
    private double averageHomePrice; // Average home price in CAD
    private int transitAccessibility; // Transit rating out of 10 based on accessibiliy and variety of transit options

    /**
     * Constructor for Neighbourhood class.
     * 
     * @param name                 The name of the neighbourhood
     * @param crimeRate            The crime rate per 1,000 people
     * @param averageHomePrice     The average home price in CAD
     * @param transitAccessibility A rating out of 10 for transit accessibility
     */
    public Neighbourhood(String name, double crimeRate, double averageHomePrice, int transitAccessibility) {
        this.name = name;
        this.crimeRate = crimeRate;
        this.averageHomePrice = averageHomePrice;
        this.transitAccessibility = transitAccessibility;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCrimeRate() {
        return crimeRate;
    }

    public double getAverageHomePrice() {
        return averageHomePrice;
    }

    public int getTransitAccessibility() {
        return transitAccessibility;
    }

    /**
     * Overrides toString() to provide a readable description of the neighbourhood
     * @return String description of the neighbourhood
     */
    @Override
    public String toString() {
        return "Neighbourhood: " + name +
                "\nCrime Rate: " + crimeRate +
                "\nAverage Home Price: $" + averageHomePrice +
                "\nTransit Accessibility: " + transitAccessibility + "/10\n";
    }
}
