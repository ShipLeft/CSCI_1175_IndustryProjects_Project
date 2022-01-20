import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Test;

/**
 * <h1>HoursAndFinancesTest</h1>
 *
 * <p>This class tests the HoursAndFinances.java class to make sure
 * that all of the methods that return values
 * are returning the correct values</p>
 *
 * <p>Created: 01/20/2022<p>
 *
 * @author Rhett Boatright
 *
 */
public class HoursAndFinancesTest {

    @Test
    public void test() {
        HoursObject hoursTest = new HoursObject();
        hoursTest.setTime(50.5);

        double getTimeTest = hoursTest.getTime();
        double getTimeExpected = 50.5;
        assertEquals(getTimeExpected, getTimeTest, 0);

        String totalStringTest = hoursTest.totalString();
        String totalStringExpected = "\nTotal time used: 50.5"
                + "\nAmount of time left in the week: 117.5";
        assertEquals(totalStringExpected, totalStringTest);

        Finances financesTest = new Finances();
        financesTest.setAmountMade(3000.24);
        financesTest.setAmountSpent(2457.78);

        String getAmountMadeTest = financesTest.getAmountMade();
        String getAmountMadeExpected = "3000.24";
        assertEquals(getAmountMadeExpected, getAmountMadeTest);

        String getAmountSpentTest = financesTest.getAmountSpent();
        String getAmountSpentExpected = "$2457.78";
        assertEquals(getAmountSpentExpected, getAmountSpentTest);

        String getStringTest = financesTest.getString();
        String getStringExpected = "Monthly income is: $3000.24"
                + "\nMonthly expenses total: $2457.78"
                + "\nMoney left over after expenses: $542.46";
        assertEquals(getStringExpected, getStringTest);
    }
}
