import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses data from a CSV file so that it's data is usable for calculations.
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class BankStatementCSVParser implements BankStatementParser {

    /**
     * Utilizes the DateTimeFormatter class to specify that the da te pattern is dd-MM-yyyy.
     */
    private static final DateTimeFormatter DATE_PATTERN
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Parses date, amount, and description of a single transaction in the CSV file.
     *
     * @param line
     * @return Bank Transaction
     */
    public BankTransaction parseFrom (final String line) {

        /* Array of String's columns is created using .split() with "," as the regex */
        final String[] columns = line.split(",");

        /* A new BankTransaction is created from columns
            [0] -> date
            [1] -> amount
            [2] -> description
         */
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    /**
     * Creates a list of Bank Transactions by looping over the CSV file.
     *
     * @param lines
     * @return List of BankTransaction
     */
    public List<BankTransaction> parseLinesFrom (final List<String> lines) {

        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            /* Utilizes the method parseFrom() declared above to create a BankTransaction object for each line */
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
