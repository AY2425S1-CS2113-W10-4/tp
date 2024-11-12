/*
package seedu.command;

import seedu.transaction.Transaction;

import java.util.List;

// Command class for adding a new Tranction
public class DeadAddTranctionCommand extends Command {
    public static final String COMMAND_WORD = "add-tranction";
    // A guide or description of the command
    public static final String COMMAND_GUIDE = "add-tranction tranction_NAME: Add a new tranction";
    public static final String[] COMMAND_MANDATORY_KEYWORDS = {};

    private Transaction transactionList;

    public DeadAddTranctionCommand(Transaction transactionList) {
        this.transactionList= transactionList;
    }

    @Override
    public List<String> execute() {
        if (!isArgumentsValid()) {
            return List.of(LACK_ARGUMENTS_ERROR_MESSAGE);
        }
        String TranctionName = arguments.get("");
        Transaction Tranction = new Transaction(TranctionName);
        TranctionList.addTranction(Tranction);
        return List.of("Tranction added: " + TranctionName);
    }
    @Override
    protected String[] getMandatoryKeywords() {
        return COMMAND_MANDATORY_KEYWORDS;
    }

    @Override
    protected String[] getExtraKeywords() {
        return new String[0];
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
*/
