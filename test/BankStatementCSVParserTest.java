import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * JUnit 4 Tester for BankStatementCSVParser.
 * Tests: parseOneCorrectLine().
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    /**
     * Checks to see if the method parseFrom(String line) is working as expected.
     */
    @Test
    public void parseOneCorrectLine() {
        /*
        Use Assert.fail() when creating a test file but the method isn't finished.
        Example: Assert.fail("Not yet implemented");
        */

        final String line = "26-12-2017,-300,Amazon";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected
                = new BankTransaction(LocalDate.of(2017, Month.DECEMBER, 26), -300,
                "Amazon");

        final double tolerance = 0d; // delta ("equal within range")

        /* Checks date, amount, and description */
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
