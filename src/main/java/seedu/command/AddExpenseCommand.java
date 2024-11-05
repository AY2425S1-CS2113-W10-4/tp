package seedu.command;

import seedu.category.Category;
import seedu.datastorage.Storage;
import seedu.transaction.Expense;
import seedu.transaction.Transaction;
import seedu.transaction.TransactionList;
import seedu.utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static seedu.message.ErrorMessages.LACK_ARGUMENTS_ERROR_MESSAGE;

public class AddExpenseCommand extends AddTransactionCommand {
    public static final String COMMAND_WORD = "add-expense";
    public static final String COMMAND_GUIDE = "add-expense [DESCRIPTION] [a/ AMOUNT] [d/ DATE] [c/ CATEGORY]";
    public static final String[] COMMAND_MANDATORY_KEYWORDS = {"a/"};
    public static final String[] COMMAND_EXTRA_KEYWORDS = {"d/", "c/"};
    public static final String ERROR_MESSAGE = "Error creating Expense!";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public AddExpenseCommand(TransactionList transactions) {
        super(transactions);
    }


    @Override
    public List<String> execute() {
        if (!isArgumentsValid()) {
            return List.of(LACK_ARGUMENTS_ERROR_MESSAGE);
        }

        if (!isArgumentsValid()) {
            return List.of("Missing mandatory fields!");
        }

        try {
            Transaction transaction = buildTransaction();
            transactions.addTransaction(transaction);
            Storage.saveTransaction(transactions.getTransactions());
            return List.of("Expense added successfully!");
        } catch (Exception e) {
            return List.of(ERROR_MESSAGE + ": " + e.getMessage());
        }
    }

    private Transaction buildTransaction() throws Exception {
        String expenseName = getExpenseName();
        double amount = parseAmount();
        String dateString = getFormattedDate();
        Category category = parseCategory();

        return category != null
                ? createTransaction(amount, expenseName, dateString, category)
                : createTransaction(amount, expenseName, dateString);
    }

    private String getExpenseName() {
        String expenseName = arguments.get("");
        return (expenseName == null || expenseName.isEmpty()) ? "" : expenseName;
    }

    private double parseAmount() throws Exception {
        String amountString = arguments.get(COMMAND_MANDATORY_KEYWORDS[0]);
        try {
            return Double.parseDouble(amountString);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid amount");
        }
    }

    private String getFormattedDate() throws Exception {
        String dateString = arguments.get(COMMAND_EXTRA_KEYWORDS[0]);
        if (dateString == null || dateString.isEmpty()) {
            return LocalDateTime.now().format(DATE_TIME_FORMATTER);
        }
        DateTimeUtils.parseDateTime(dateString);
        return dateString;
    }

    private Category parseCategory() {
        String categoryString = arguments.get(COMMAND_EXTRA_KEYWORDS[1]);
        return (categoryString != null && !categoryString.isEmpty())
                ? new Category(categoryString)
                : null;
    }

    @Override
    protected Transaction createTransaction(double amount, String description, String date) throws Exception {
        return new Expense(amount, description, date);
    }

    protected Transaction createTransaction(double amount, String description,
                                            String date, Category category) throws Exception {
        return new Expense(amount, description, date, category);
    }

    @Override
    protected String[] getMandatoryKeywords() {
        return COMMAND_MANDATORY_KEYWORDS;
    }

    @Override
    protected String[] getExtraKeywords() {
        return COMMAND_EXTRA_KEYWORDS;
    }

    @Override
    protected String getCommandWord() {
        return COMMAND_WORD;
    }

    @Override
    protected String getCommandGuide() {
        return COMMAND_GUIDE;
    }
}