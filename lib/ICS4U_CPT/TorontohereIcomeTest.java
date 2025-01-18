package lib.ICS4U_CPT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class TorontohereIcomeTest {
    private LinkedList<Neighbourhood> neighborhoods;

    @Before
    public void setUp() {
        neighborhoods = new LinkedList<>();
        neighborhoods.add(new Neighbourhood("The Annex", 4.2, 1100000, 8));
        neighborhoods.add(new Neighbourhood("The Beaches", 3.5, 1250000, 6));
        neighborhoods.add(new Neighbourhood("Cabbagetown", 5.1, 950000, 7));
        neighborhoods.add(new Neighbourhood("Yorkville", 6.7, 1500000, 9));
        neighborhoods.add(new Neighbourhood("Kensington Market", 5.5, 850000, 5));
        neighborhoods.add(new Neighbourhood("Distillery District", 4.9, 1000000, 8));
    }

    @Test
    public void testGetMinimumPrice() {
        double minPrice = TorontohereIcome.getMinimumPrice(neighborhoods);
        assertEquals(850000, minPrice, 0);
    }

    @Test
    public void testFindBestNeighborhood_LowCrimeRate() {
        UserPreferences preferences = new UserPreferences(1300000, 1);
        Neighbourhood best = TorontohereIcome.findBestNeighbourhood(neighborhoods, preferences);

        assertEquals("The Beaches", best.getName());
    }

    @Test
    public void testFindBestNeighborhood_AffordableHousing() {
        UserPreferences preferences = new UserPreferences(1300000, 2);
        Neighbourhood best = TorontohereIcome.findBestNeighbourhood(neighborhoods, preferences);

        assertEquals("Kensington Market", best.getName());
    }

    @Test
    public void testFindBestNeighborhood_TransitAccessibility() {
        UserPreferences preferences = new UserPreferences(1000000, 3);
        Neighbourhood best = TorontohereIcome.findBestNeighbourhood(neighborhoods, preferences);

        assertEquals("Distillery District", best.getName());
    }
}