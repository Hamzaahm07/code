package lib.ICS4U_CPT;

public class Neighbourhood {
    private String name;
    private double crimeRate; // Per 1,000 people
    private double averageHomePrice; // In CAD
    private int transitAccessibility; // Rating out of 10

    public Neighbourhood(String name, double crimeRate, double averageHomePrice, int transitAccessibility) {
        this.name = name;
        this.crimeRate = crimeRate;
        this.averageHomePrice = averageHomePrice;
        this.transitAccessibility = transitAccessibility;
    }

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

    @Override
    public String toString() {
        return name + " - Crime Rate: " + crimeRate + "/1000, Average Home Price: $" +
                averageHomePrice + ", Transit Accessibility: " + transitAccessibility + "/10";
    }
}
