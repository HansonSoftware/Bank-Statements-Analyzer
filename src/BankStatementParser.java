import java.util.List;

/**
 * Interface for the Bank Statement CSV Parser.
 *
 * @author Hayden Hanson
 * @version 1.0
 */
public interface BankStatementParser {
    BankTransaction parseFrom (String line);
    List<BankTransaction> parseLinesFrom (List<String> lines);
}
