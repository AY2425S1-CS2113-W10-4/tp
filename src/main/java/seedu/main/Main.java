package seedu.main;

import seedu.category.CategoryList;
import seedu.command.AddCategoryCommand;
import seedu.command.ByeCommand;
import seedu.command.Command;
import seedu.command.DeleteCategoryCommand;
import seedu.command.HelpCommand;
import seedu.command.HistoryCommand;
import seedu.command.ViewCategoryCommand;
import seedu.command.ViewExpenseCommand;
import seedu.command.ViewIncomeCommand;
import seedu.command.AddIncomeCommand;
import seedu.command.AddExpenseCommand;
import seedu.command.DeleteTransactionCommand;
import seedu.command.ViewTotalCommand;
import seedu.command.KeywordsSearchCommand;

import seedu.datastorage.Storage;
import seedu.transaction.TransactionList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final String NAME = "uNivUSaver";
    public static final String HI_MESSAGE = "Hello, %s is willing to help!";
    public static final String INVALID_COMMAND_ERROR_MESSAGE = "Invalid command.";
    public static Scanner scanner; // Scanner for reading user input
    private static final Logger logger = Logger.getLogger("Main");

    // Prefix for message formatting
    private static final String PREFIX = "\t";
    // Separator for message formatting
    private static final String SEPARATOR = "-------------------------------------";

    private static Parser parser; //Parser to parse the commands

    private static UI ui;

    // Singleton CategoryList for use across classes
    private static CategoryList categories; //Category list to store categories

    // Singleton TransactionList for use across classes
    private static TransactionList transactions;

    private static boolean isRunning = true;



    public static void main(String[] args) {
        while (isRunning) {
            run();
        }
    }

    /**
     * Setter for the chatbot's running state.
     *
     * @param isRunning A boolean showing if the chatbot should continue running.
     */
    public static void setRunning(boolean isRunning) {
        Main.isRunning = isRunning;
    }

    /**
     * Starts the chatbot and enters the command processing loop.
     */
    public static void run() {
        try {
            start();
            runCommandLoop();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    /**
     * Starts the chatbot by printing the logo and greeting messages,
     * and sign up the Command objects.
     */
    public static void start() {
        logger.log(Level.INFO, "Starting uNivUSaver...");
        ui = new UI();
        parser = new Parser();

        categories = new CategoryList();
        categories.setCategories(Storage.loadCategories());
        Storage.saveCategory(categories.getCategories()); //Save categories in case of initialization

        transactions = new TransactionList();
        transactions.setTransactions(Storage.loadTransactions());

        setupCommands();

        ui.printMessage(String.format(HI_MESSAGE, NAME));
    }

    /**
     * Signs up the Command objects.
     */
    private static void setupCommands() {
        assert categories != null : "Categories should be initialized.";
        assert transactions != null : "Transactions should be initialized.";

        HelpCommand helpCommand = new HelpCommand();
        parser.registerCommands(helpCommand);

        parser.registerCommands(new AddCategoryCommand(categories));
        parser.registerCommands(new AddIncomeCommand(transactions));
        parser.registerCommands(new AddExpenseCommand(transactions));

        parser.registerCommands(new DeleteCategoryCommand(categories));
        parser.registerCommands(new DeleteTransactionCommand(transactions));

        parser.registerCommands(new ViewCategoryCommand(categories));
        parser.registerCommands(new ViewExpenseCommand(transactions));
        parser.registerCommands(new ViewIncomeCommand(transactions));
        parser.registerCommands(new ViewTotalCommand(transactions));
        parser.registerCommands(new HistoryCommand(transactions));


        KeywordsSearchCommand keywordsSearchCommand = new KeywordsSearchCommand(transactions);
        parser.registerCommands(keywordsSearchCommand);

        parser.registerCommands(new ByeCommand());


        // Set command list for the help command
        logger.log(Level.INFO, "Setting command list for HelpCommand...");
        helpCommand.setCommands(new ArrayList<>(parser.getCommands().values()));
    }

    /**
     * Main command processing loop that retrieves user commands, processes, and displays the results.
     * The loop continues until the application is stopped.
     */
    private static void runCommandLoop() throws Exception {
        while (isRunning) {
            String commandString = ui.getUserInput();
            String[] commandParts = commandString.split(" ", 2);

            Command command = parser.parseCommand(commandParts[0]);

            if (command == null) {
                List<String> messages = new ArrayList<>();
                messages.add(INVALID_COMMAND_ERROR_MESSAGE);
                ui.showCommandResult(messages);
                continue;
            }

            if (commandParts.length == 2) {
                Map<String, String> arguments = parser.extractArguments(command, commandParts[1]);
                command.setArguments(arguments);
            }

            List<String> messages = command.execute();
            ui.showCommandResult(messages);
        }
    }
}
