package lib.ICS4U_CPT;

/**
 * author: Hamza Ahmed
 * date: 2025/01/15
 * Stores user preferences e.g., budget and priority when analyzing each
 * neighbourhood
 */

public class UserPreferences {
    private double budget; // The users budget in CAD (assuming Canadians are running this program)
    private int priority; // Priority: 1 = Low Crime, 2 = Low Price, 3 = High Transit

    /**
     * Constructor for this class
     * 
     * @param budget   The user's budget in CAD
     * @param priority The user's priority for selecting a neighbourhood
     */
    public UserPreferences(double budget, int priority) {
        this.budget = budget;
        this.priority = priority;
    }

    // Getters
    public double getBudget() {
        return budget;
    }

    public int getPriority() {
        return priority;
    }
}