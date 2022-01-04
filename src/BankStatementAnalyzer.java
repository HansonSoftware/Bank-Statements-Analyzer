import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * The BankStatementAnalyzer collects and outputs a summary of the CSV file given on the command line.
 * The file must also be placed in the resources file.
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class BankStatementAnalyzer {

    /* '../resources/' is the file path to reach the CSV from this file */
    private static final String RESOURCES = "../resources/";

    /* initialization of the Parser object */
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    /**
     * This method takes in the CSV file name and a Parser object as parameters.
     * It collects a summary of the bank statement given and outputs various calculations to the screen.
     *
     * @param fileName
     * @param bankStatementParser
     * @throws IOException
     */
    public void analyze (final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        /* Utilizes java.nio.file.Path methods to get the file path to the CSV.
            Then reads all lines in the file and stores the contents as a List of Strings. */
        final Path path = Paths.get(RESOURCES, fileName);
        final List<String> lines = Files.readAllLines(path);

        /* Initializes a List of BankTransaction's using the Parser.
            Then initializes a BankStatementProcessor using the List of BankTransaction's. */
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    /**
     * Outputs calculations from each BankStatement using the BankStatementProcessor object.
     *
     * @param bankStatementProcessor
     */
    private static void collectSummary (final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateAmount());

        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total for transactions in March is "
                + bankStatementProcessor.calculateTotalInMonth(Month.MARCH));

        System.out.println("The total for transactions in April is "
                + bankStatementProcessor.calculateTotalInMonth(Month.APRIL));

        System.out.println("The total for transactions in May is "
                + bankStatementProcessor.calculateTotalInMonth(Month.MAY));

        System.out.println("The total for transactions in June is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JUNE));

        System.out.println("The total for transactions in July is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JULY));

        System.out.println("The total for transactions in August is "
                + bankStatementProcessor.calculateTotalInMonth(Month.AUGUST));

        System.out.println("The total for transactions in September is "
                + bankStatementProcessor.calculateTotalInMonth(Month.SEPTEMBER));

        System.out.println("The total for transactions in October is "
                + bankStatementProcessor.calculateTotalInMonth(Month.OCTOBER));

        System.out.println("The total for transactions in November is "
                + bankStatementProcessor.calculateTotalInMonth(Month.NOVEMBER));

        System.out.println("The total for transactions in December is "
                + bankStatementProcessor.calculateTotalInMonth(Month.DECEMBER));

        System.out.println("The total salary received was "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
