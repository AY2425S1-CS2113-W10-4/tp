/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import seedu.category.Category;
import seedu.category.CategoryList;
import seedu.transaction.Expense;
import seedu.transaction.Transaction;
import seedu.transaction.TransactionList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JUnitTest {

    @Test
    public void testCategoryCreation() {
        // Arrange
        String categoryName = "Food";

        // Act
        Category category = new Category(categoryName);

        // Assert
        assertEquals(categoryName, category.getName(), "The category name should match the input name.");
    }

    @Test
    public void testGetName() {
        // Arrange
        String categoryName = "Entertainment";
        Category category = new Category(categoryName);

        // Act
        String result = category.getName();

        // Assert
        assertEquals(categoryName, result, "The getName() method should return the correct category name.");
    }

    @Test
    public void testAddCategory() {
        // Arrange
        CategoryList categoryList = new CategoryList();
        String newCategoryName = "Health";
        Category newCategory = new Category(newCategoryName);

        // Act
        categoryList.addCategory(newCategory);
        List<Category> categories = categoryList.getCategories();

        // Assert
        boolean categoryExists = categories.stream().anyMatch(c -> c.getName().equalsIgnoreCase(newCategoryName));
        assertTrue(categoryExists, "The new category should be added to the list.");
    }

    @Test
    public void testDeleteCategory() {
        // Arrange
        CategoryList categoryList = new CategoryList();
        String categoryNameToDelete = "Food";

        // Act
        categoryList.deleteCategory(categoryNameToDelete);
        List<Category> categories = categoryList.getCategories();

        // Assert
        boolean categoryExists = categories.stream().anyMatch(c -> c.getName().equalsIgnoreCase(categoryNameToDelete));
        assertFalse(categoryExists, "The category should be deleted from the list.");
    }

    @Test
    public void testListCategories() {
        // Arrange
        CategoryList categoryList = new CategoryList();

        // Act
        List<Category> categories = categoryList.getCategories();

        // Assert
        assertNotNull(categories, "The category list should not be null.");
        assertTrue(categories.size() > 0, "The category list should contain default categories.");
    }

    @Test
    public void testAddTransaction() throws Exception {
        TransactionList transactionList = new TransactionList();
        Transaction transaction = new Expense(100.0, "Groceries", "2024-10-10",
                new Category("Food"));

        transactionList.addTransaction(transaction);
        List<Transaction> transactions = transactionList.getTransactions();

        assertTrue(transactions.contains(transaction), "The transaction should be added to the list.");
    }

    @Test
    public void testDeleteTransaction() throws Exception {
        TransactionList transactionList = new TransactionList();
        Transaction transaction = new Expense(50.0, "Taxi", "2024-10-11",
                new Category("Transport"));
        transactionList.addTransaction(transaction);
        int initialSize = transactionList.getTransactions().size();

        transactionList.deleteTransaction(0);
        int newSize = transactionList.getTransactions().size();

        assertEquals(initialSize - 1, newSize, "The transaction should be removed from the list.");
    }

    @Test
    public void testListTransactions() throws Exception {
        TransactionList transactionList = new TransactionList();
        transactionList.addTransaction(new Expense(20.0, "Coffee", "2024-10-09",
                new Category("Food")));

        List<Transaction> transactions = transactionList.getTransactions();

        assertNotNull(transactions, "The transaction list should not be null.");
        assertTrue(transactions.size() > 0, "The transaction list should contain at" +
                " least one transaction.");
    }

    @Test
    public void testTransactionCreation() throws Exception {
        double amount = 150.0;
        String description = "Dinner";
        String date = "2024-10-12";
        Category category = new Category("Food");

        Transaction transaction = new Expense(amount, description, date, category);

        assertEquals(amount, transaction.getAmount(), "The transaction amount should match the input amount.");
        assertEquals(description, transaction.getDescription(), "The transaction description should match " +
                "the input description.");
        assertEquals(LocalDateTime.parse(date + " 2359", DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")),
                transaction.getDate(), "The transaction date should match the input date.");
    }

    @Test
    public void testTransactionToString() throws Exception {
        Transaction transaction = new Expense(75.0, "Movie", "2024-10-13",
                new Category("Entertainment"));
        String expectedString = "Expense [amount=75.0, description=Movie, date=Sunday, 2024-10-13 11.59 PM, " +
                "category=Entertainment]";

        String result = transaction.toString();

        assertEquals(expectedString, result, "The toString() method should return the correct transaction " +
                "details.");
    }
}
*/
