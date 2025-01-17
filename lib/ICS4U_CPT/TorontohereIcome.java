package lib.ICS4U_CPT;

import java.util.LinkedList;
import java.util.Scanner;

public class TorontohereIcome {

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

            // Display the neighborhoods
            System.out.println("Welcome to 'Toronto: Your New Home'!");
            System.out.println("\nHere are the available neighborhoods in Toronto:");
            for (Neighbourhood neighbourhood : neighborhoods) {
                System.out.println("- " + neighbourhood.getName());
            }
            System.out.println(); // Add a blank line for spacing

            // Ask the user what they want to do
            System.out.println("Would you like to:");
            System.out.println("1. Find the best neighborhood for you");
            System.out.println("2. Learn more about a specific neighborhood");
            System.out.print("Enter 1 or 2: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Proceed to finding the best neighborhood
                System.out.print("\nEnter your budget (CAD): ");
                double budget = scanner.nextDouble();

                // Check if budget is too low
                double minPrice = getMinimumPrice(neighborhoods);
                if (budget < minPrice) {
                    System.out.println(
                            "\nUh oh! This budget is too low, unfortunately. Please try again with a higher budget.\n");
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
                    System.out.println(
                            "\nThis neighborhood matches your preferences and budget. Wishing you all the best in your home search!");
                } else {
                    System.out.println(
                            "\nNo neighbourhood matches your budget and preferences. Please try adjusting your budget or priorities.");
                }
            } else if (choice == 2) {
                // Let the user view stats for a specific neighborhood
                System.out.print("\nEnter the name of the neighborhood you'd like to learn about: ");
                String neighborhoodName = scanner.nextLine();

                // Find and display the neighborhood stats
                Neighbourhood foundNeighborhood = null;
                for (Neighbourhood neighborhood : neighborhoods) {
                    if (neighborhood.getName().equalsIgnoreCase(neighborhoodName)) {
                        foundNeighborhood = neighborhood;
                        break;
                    }
                }

                if (foundNeighborhood != null) {
                    System.out.println("\nHere are the stats for " + foundNeighborhood.getName() + ":");
                    System.out.println(foundNeighborhood);
                } else {
                    System.out.println(
                            "\nSorry, no neighborhood by that name was found. Please check the spelling and try again.");
                }
            } else {
                System.out.println("\nInvalid choice. Please enter 1 or 2.");
                continue; // Restart the loop
            }

            // Ask if the user wants to restart
            System.out.print("\nWould you like to restart? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("no")) {
                running = false;
                System.out.println(
                        "\nThank you for using 'Toronto: Your New Home'! Wishing you the best in your home search. Goodbye!");
            } else if (!response.equals("yes")) {
                System.out.println("\nInvalid response. Exiting program.");
                running = false;
            }
        }

        scanner.close();
    }

    // Method to get the minimum price of all neighborhoods
    private static double getMinimumPrice(LinkedList<Neighbourhood> neighborhoods) {
        double minPrice = Double.MAX_VALUE; // Start with the maximum possible value
        for (Neighbourhood neighborhood : neighborhoods) {
            if (neighborhood.getAverageHomePrice() < minPrice) {
                minPrice = neighborhood.getAverageHomePrice();
            }
        }
        return minPrice;
    }

    // Method to find the best neighborhood based on user preferences
    private static Neighbourhood findBestNeighbourhood(LinkedList<Neighbourhood> neighborhoods, UserPreferences preferences) {
        Neighbourhood bestMatch = null;
        double bestScore = -1; // Initialize with a low score
        
        for (Neighbourhood neighborhood : neighborhoods) {
            // Check if the neighborhood is within budget
            if (neighborhood.getAverageHomePrice() <= preferences.getBudget()) {
                // Calculate a score based on user priority
                double score = 0;
                switch (preferences.getPriority()) {
                    case 1: // Priority: Low Crime Rate
                        score = 10 - neighborhood.getCrimeRate();
                        break;
                    case 2: // Priority: Affordable Housing
                        score = (preferences.getBudget() - neighborhood.getAverageHomePrice()) / 100000; // Higher leftover budget = higher score
                        break;
                    case 3: // Priority: Transit Accessibility
                        score = neighborhood.getTransitAccessibility();
                        break;
                    default:
                        break;
                }
                // Keep track of the best-scoring neighborhood
                if (score > bestScore) {
                    bestScore = score;
                    bestMatch = neighborhood;
                }
            }
        }
        return bestMatch;
    }
}