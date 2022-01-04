import java.time.LocalDate;
import java.util.List;

/**
 * Data Access Object.
 *
 * @author Hayden Hanson
 * @version 1.0
 */
public class BankTransactionDAO {

    private final List<BankTransaction> bankTransactions;

    public BankTransactionDAO (List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public BankTransaction create(final LocalDate date, final double amount, final String description) {

        BankTransaction newTransaction = new BankTransaction(date, amount, description);
        bankTransactions.add(newTransaction);

        return newTransaction;
    }

    public BankTransaction read(final int id) {
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.hashCode() == id) {
                return transaction;
            }
        }
        return null;
    }

    public BankTransaction update(final int id) {
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.hashCode() == id) {
                return transaction;
            }
        }
        return null;
    }

    public void delete(final BankTransaction bankTransaction) {

        for (final BankTransaction transaction : bankTransactions) {
            if (transaction.equals(bankTransaction)) {
                bankTransactions.remove(transaction);
            }
        }
    }
}
