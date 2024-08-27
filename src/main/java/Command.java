/**
 * Includes method to determine if current command is exiting command,
 * and method to execute specific commands according to subclass.
 * Serves as the parent class for subclasses AddCommand, MarkCommand,
 * UnmarkCommand, DeleteCommand, PrintCommand and ExitCommand.
 */
public abstract class Command {
    // Determines if command is exit command.
    public abstract boolean isExit();

    // Executes specific command for each subclass.
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DeltaException;
}
