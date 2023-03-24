package seedu.address.logic.commands;

import java.util.List;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final List<String> COMMAND_WORDS = List.of(new String[]{"help", "h"});

    public static final String MESSAGE_USAGE = COMMAND_WORDS + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORDS;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
