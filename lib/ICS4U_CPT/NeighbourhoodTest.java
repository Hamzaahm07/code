package lib.ICS4U_CPT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NeighbourhoodTest {

    private Neighbourhood neighbourhood;

    @Before
    public void setUp() {
        neighbourhood = new Neighbourhood("The Annex", 4.2, 1100000, 8);
    }

    @Test
    public void testGetName() {
        assertEquals("The Annex", neighbourhood.getName());
    }

    @Test
    public void testGetCrimeRate() {
        assertEquals(4.2, neighbourhood.getCrimeRate(), 0);
    }

    @Test
    public void testGetAverageHomePrice() {
        assertEquals(1100000, neighbourhood.getAverageHomePrice(), 0);
    }

    @Test
    public void testGetTransitAccessibility() {
        assertEquals(8, neighbourhood.getTransitAccessibility());
    }

    @Test
    public void testToString() {
        String expectedDescription = "Neighbourhood: The Annex\n" +
                "Crime Rate: 4.2\n" +
                "Average Home Price: $1100000.0\n" +
                "Transit Accessibility: 8/10\n";
        assertEquals(expectedDescription, neighbourhood.toString());
    }
}
