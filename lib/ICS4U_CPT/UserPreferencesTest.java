package lib.ICS4U_CPT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserPreferencesTest {

    private UserPreferences userPreferences;

    @Before
    public void setUp() {
        userPreferences = new UserPreferences(1300000, 2);
    }

    @Test
    public void testGetBudget() {
        assertEquals(1300000, userPreferences.getBudget(), 0);
    }

    @Test
    public void testGetPriority() {
        assertEquals(2, userPreferences.getPriority());
    }
}
