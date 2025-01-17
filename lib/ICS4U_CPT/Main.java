package lib.ICS4U_CPT;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * File: Main.java
 * Description: Main program to find the best neighbourhood for a user based on their preferences.
 * Author: Joe
 * Date: January 2025
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        boolean running = true;
        while (running) {
            // Create a list of neighborhoods
            LinkedList<Neighbourhood> neighborhoods = new LinkedList<>();
            neighborhoods.add(new Neighbourhood("The Annex", 4.2, 1100000, 8));
            neighborhoods.add(new Neighbourhood("The Beaches", 3.5, 1250000, 6));
            neighborhoods.add(new Neighbourhood("Cabbagetown", 5.1, 950000, 7));
            neighborhoods.add(new Neighbourhood("Yorkville", 6.7, 1500000, 9));
            neighborhoods.add(new Neighbourhood("Kensington Market", 5.5, 850000, 5));
            neighborhoods.add(new Neighbourhood("Distillery District", 4.9, 1000000, 8));

            // Get user preferences
            System.out.println("Welcome to 'Toronto: Your New Home'!");
            System.out.print("Enter your budget (CAD): ");
            double budget = scanner.nextDouble();

            // Check if budget is too low
            double minPrice = getMinimumPrice(neighborhoods);
            if (budget < minPrice) {
                System.out.println("\nUh oh! This budget is too low, unfortunately. Please try again with a higher budget.\n");
                continue; // Restart the loop
            }

            System.out.println("What's your top priority?");
            System.out.println("1. Low Crime Rate\n2. Affordable Housing\n3. Accessibility to Transit");
            System.out.print("Enter 1, 2, or 3: ");
            int priority = scanner.nextInt();

            UserPreferences preferences = new UserPreferences(budget, priority);

            // Find the best neighborhood
            Neighbourhood bestNeighbourhood = findBestNeighbourhood(neighborhoods, preferences);
            if (bestNeighbourhood != null) {
                System.out.println("\nThe best neighbourhood for you is:\n");
                System.out.println(bestNeighbourhood);
            } else {
                System.out.println("\nNo neighbourhood matches your budget and preferences.");
            }

            // Ask if the user wants to restart
            System.out.print("\nWould you like to restart? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("no")) {
                running = false;
                System.out.println("\nThank you for using 'Toronto: Your New Home'! Goodbye!");
            } else if (!response.equals("yes")) {
                System.out.println("\nInvalid response. Exiting program.");
                running = false;
            }
        }

        scanner.close();
    }

    /**
     * Finds the best neighbourhood based on user preferences.
     * @param neighborhoods The list of neighbourhoods.
     * @param preferences The user's preferences.
     * @return The best-matching neighbourhood, or null if no match is found.
     */
    public static Neighbourhood findBestNeighbourhood(LinkedList<Neighbourhood> neighborhoods, UserPreferences preferences) {
        Neighbourhood best = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (Neighbourhood neighbourhood : neighborhoods) {
            double score = calculateScore(neighbourhood, preferences);

            if (score > bestScore && neighbourhood.getAverageHomePrice() <= preferences.getBudget()) {
                best = neighbourhood;
                bestScore = score;
            }
        }
        return best;
    }

    /**
     * Calculates a score for a neighbourhood based on user preferences.
     * @param neighbourhood The neighbourhood to evaluate.
     * @param preferences The user's preferences.
     * @return A double score for the neighbourhood.
     */
    public static double calculateScore(Neighbourhood neighbourhood, UserPreferences preferences) {
        switch (preferences.getPriority()) {
            case 1: // Low Crime Rate
                return 10 - neighbourhood.getCrimeRate();
            case 2: // Affordable Housing
                return 1.0 / neighbourhood.getAverageHomePrice();
            case 3: // Accessibility to Transit
                return neighbourhood.getTransitAccessibility();
            default:
                return 0;
        }
    }

    /**
     * Gets the minimum home price among all neighbourhoods.
     * @param neighborhoods The list of neighbourhoods.
     * @return The minimum home price.
     */
    public static double getMinimumPrice(LinkedList<Neighbourhood> neighborhoods) {
        double minPrice = Double.MAX_VALUE;
        for (Neighbourhood neighbourhood : neighborhoods) {
            if (neighbourhood.getAverageHomePrice() < minPrice) {
                minPrice = neighbourhood.getAverageHomePrice();
            }
        }
        return minPrice;
    }
}
