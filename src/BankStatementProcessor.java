import java.time.Month;
import java.util.List;

/**
 * Processor object useful for calculations and summary.
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    /**
     * Constructor: initializes List of BankTransaction's.
     *
     * @param bankTransactions
     */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * Calculates the total amount of all transactions in the file.
     *
     * @return total
     */
    public double calculateAmount () {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    /**
     * Calculates the total amount of all transactions in the given month.
     *
     * @param month
     * @return total
     */
    public double calculateTotalInMonth (final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    /**
     * Calculates the total amount of all transactions in the given category.
     *
     * @param category
     * @return total
     */
    public double calculateTotalForCategory (final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
