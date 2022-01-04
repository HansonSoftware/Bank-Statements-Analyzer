import java.time.LocalDate;
import java.util.Objects;

/**
 * A "Bank Transaction" is an object that stores the date, amount, and a description of each transaction in CSV provided
 * from the bank.
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    /**
     * A BankTransaction object contains a date, amount, and a description.
     *
     * @param date
     * @param amount
     * @param description
     */
    public BankTransaction (final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    /* Getters */
    public LocalDate getDate () { return date; }
    public double getAmount () { return amount; }
    public String getDescription () { return description; }

    @Override
    public String toString () {
        return "Bank Transaction{" + "date = " + date + ", amount = " + amount + ", description = " + description + '\''
                + '}';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, this.amount) == 0 &&
                this.date.equals(that.date) &&
                this.description.equals(that.description);
    }

    @Override
    public int hashCode () {
        return Objects.hash(date, amount, description);
    }

}
