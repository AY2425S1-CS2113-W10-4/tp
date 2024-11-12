package seedu.transaction;

import seedu.category.Category;
import java.util.logging.Logger;

public class TransactionEditor {
    private static final Logger logger = Logger.getLogger("TransactionEditor");
    private final TransactionList transactionList;

    public TransactionEditor(TransactionList transactionList) {
        this.transactionList = transactionList;
    }


    public boolean updateCategory(int index, Category newCategory) {
        if (index >= 0 && index < transactionList.size()) {
            Transaction transaction = transactionList.getTransactions().get(index);
            if (transaction instanceof Expense) {
                ((Expense) transaction).setCategory(newCategory);
                logger.info("Transaction category updated at index " + index);
                return true;
            }
        }
        logger.warning("Failed to update category at index " + index);
        return false;
    }
}
