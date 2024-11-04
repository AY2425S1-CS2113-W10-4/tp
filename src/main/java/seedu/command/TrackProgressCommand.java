package seedu.command;

import seedu.budget.BudgetTracker;
import seedu.message.CommandResultMessages;
import seedu.message.ErrorMessages;
import java.time.YearMonth;
import java.util.List;
import static seedu.utils.DateTimeUtils.parseYearMonth;

public class TrackProgressCommand extends Command {
    public static final String COMMAND_WORD = "track";
    public static final String COMMAND_GUIDE = "track m/ MONTH: " +
            "Track your progress towards your budget for a certain month";
    public static final String[] COMMAND_MANDATORY_KEYWORDS = {"m/"};
    public static final String[] COMMAND_EXTRA_KEYWORDS = {};

    private final BudgetTracker budgetTracker;

    public TrackProgressCommand(BudgetTracker budgetTracker) {
        this.budgetTracker = budgetTracker;
    }

    @Override
    public List<String> execute() {
        if (!isArgumentsValid()) {
            return List.of(ErrorMessages.LACK_ARGUMENTS_ERROR_MESSAGE);
        }

        String monthStr = arguments.get(COMMAND_MANDATORY_KEYWORDS[0]);
        YearMonth month = null;
        try {
            month = parseYearMonth(monthStr);
        } catch (Exception e) {
            return List.of(CommandResultMessages.TRACK_PROGRESS_FAIL +
                    ErrorMessages.MESSAGE_INVALID_YEAR_MONTH_FORMAT);
        }

        return List.of(budgetTracker.checkBudgetProgress(month));
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
