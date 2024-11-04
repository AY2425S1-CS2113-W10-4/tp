package seedu.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.category.Category;
import seedu.utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransactionListTest {

    private TransactionList transactionList;

    @BeforeEach
    public void setUp() {
        transactionList = new TransactionList();
    }

    @Test
    public void testAddTransaction() {
        Income income = new Income(1000, "Salary", "2024-11-01");
        Category Food = new Category("Food");
        Expense expense = new Expense(1000, "Salary", "2024-11-01", Food);
        transactionList.addTransaction(income);
        transactionList.addTransaction(expense);

        assertEquals(2, transactionList.size());
        assertEquals(income, transactionList.getTransactions().get(0));
        assertEquals(expense, transactionList.getTransactions().get(1));
    }


    @Test
    public void testDeleteTransactionValidIndex() {
        Income income = new Income(1000, "Salary", "2024-11-01");
        transactionList.addTransaction(income);

        Expense expense = new Expense(200, "Groceries", "2024-11-01");
        transactionList.addTransaction(expense);

        Transaction deletedTransaction = transactionList.deleteTransaction(0);

        assertEquals(income, deletedTransaction);
        assertEquals(1, transactionList.size());
    }

    @Test
    public void testDeleteTransactionInvalidIndex() {
        assertNull(transactionList.deleteTransaction(0));
    }

    @Test
    public void testGetTransactionsBetween() throws Exception {
        Income income = new Income(1000, "Salary", "2024-11-01 1000");
        transactionList.addTransaction(income);

        Expense expense = new Expense(200, "Groceries", "2024-11-01 1500");
        transactionList.addTransaction(expense);

        LocalDateTime start = DateTimeUtils.parseDateTime("2024-11-01 0900");
        LocalDateTime end = DateTimeUtils.parseDateTime("2024-11-01 1200");

        List<Transaction> transactions = transactionList.getTransactionsBetween(start, end);

        assertEquals(1, transactions.size());
        assertEquals(income, transactions.get(0));
    }

    @Test
    public void testGetExpensesByCategory() {
        Category category = new Category("Food");
        Expense expense = new Expense(100, "Lunch", "2024-11-01 1200", category);
        transactionList.addTransaction(expense);

        List<Transaction> expenses = transactionList.getExpensesByCategory(category);

        assertEquals(1, expenses.size());
        assertEquals(expense, expenses.get(0));
    }

    @Test
    public void testGetTodaySpending() {
        Expense expense = new Expense(100, "Groceries",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")));
        transactionList.addTransaction(expense);

        double todaySpending = transactionList.getTodaySpending();

        assertEquals(100, todaySpending);
    }

    @Test
    public void testUpdateCategory() throws Exception {
        Category oldCategory = new Category("Food");
        Expense expense = new Expense(100, "Lunch", "2024-11-01T12:00:00", oldCategory);
        transactionList.addTransaction(expense);

        Category newCategory = new Category("Travel");
        transactionList.updateCategory(0, newCategory);

        assertEquals(newCategory, ((Expense) transactionList.getTransactions().get(0)).getCategory());
    }
}
