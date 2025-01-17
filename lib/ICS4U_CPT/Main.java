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
            // Create a list of neighbourhoods
            LinkedList<Neighbourhood> neighborhoods = new LinkedList<>();
            neighborhoods.add(new Neighbourhood("Downtown", 7.8, 1200000, 10));
            neighborhoods.add(new Neighbourhood("Scarborough", 5.5, 850000, 6));
            neighborhoods.add(new Neighbourhood("North York", 6.3, 950000, 8));
            neighborhoods.add(new Neighbourhood("Etobicoke", 4.8, 880000, 7));
            neighborhoods.add(new Neighbourhood("East York", 5.1, 790000, 5));

            // Get user preferences
            System.out.println("Welcome to 'Toronto: Your New Home'!");
            System.out.print("Enter your budget (CAD): ");
            double budget = scanner.nextDouble();
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
}