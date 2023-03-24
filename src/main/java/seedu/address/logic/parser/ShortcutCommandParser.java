package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteTagCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ShortcutCommand;
import seedu.address.logic.commands.TagCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

import java.util.List;


/**
 * Parses input arguments and creates a new TagCommand object
 */
public class ShortcutCommandParser implements Parser<ShortcutCommand> {
    private static final int COMMAND_INDEX = 0;
    private static final int SHORT_FORM_INDEX = 1;

    public enum CommandType {
        ADD, CLEAR, DELETE, DELETE_TAG, EDIT, EXIT, EXPORT, FILTER, FIND, HELP, LIST, SHORTCUT, TAG
    }

    /**
     * Parses the given {@code String} of arguments in the context of the TagCommand
     * and returns a TagCommand object for execution.
     *
     * @param args The arguments to the TagCommand
     * @return The parsed TagCommand
     * @throws ParseException if {@code args} does not conform the expected format
     */
    public ShortcutCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ShortcutCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split(" ");
        String commandWord = nameKeywords[COMMAND_INDEX];
        String shortForm = nameKeywords[SHORT_FORM_INDEX];

        Command commandToChange = null;

        // Choose the right type
        if (commandWord.equals(AddCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new AddCommand(null);
        } else if (commandWord.equals(ClearCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new ClearCommand();
        } else if (commandWord.equals(DeleteCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new DeleteCommand(null);
        } else if (commandWord.equals(DeleteTagCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new DeleteTagCommand(null, null);
        } else if (commandWord.equals(EditCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new EditCommand(null, null);
        } else if (commandWord.equals(ExitCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new ExitCommand();
        } else if (commandWord.equals(ExportCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new ExportCommand();
        } else if (commandWord.equals(FilterCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new FilterCommand(null);
        } else if (commandWord.equals(HelpCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new HelpCommand();
        } else if (commandWord.equals(ListCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new ListCommand();
        } else if (commandWord.equals(ShortcutCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new ShortcutCommand(null, null);
        } else if (commandWord.equals(TagCommand.COMMAND_WORDS.get(0))) {
            commandToChange = new TagCommand(null, null);
        } else {
            throw new ParseException(ShortcutCommand.MESSAGE_INVALID_SHORTCUT);
        }

        return new ShortcutCommand(commandToChange, shortForm);
    }

}
