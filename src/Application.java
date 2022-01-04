import java.io.IOException;

/**
 * The main application to be run.
 * This application takes in a CSV file as a command line argument and outputs a summary of the statements.
 *
 * @author Hayden Hanson
 * @version 1.0
 */

public class Application {
    public static void main (String[] args) throws IOException {

        /* If the command line is empty upon initialization, System.exit(1) will be called and the user is notified */
        if (args.length != 1) {
            System.out.println("Enter the filename of the Bank Statement you would like to analyze.");
            System.out.println("The call should be of the format \"java Application [file-name].csv\"");
            System.exit(1);
        }

        /* Initialization of the Analyzer object */
        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        /* Initialization of the Parser object */
        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        /* The analyze(fileName, parser) method is called and outputs the summary to the terminal */
        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}
