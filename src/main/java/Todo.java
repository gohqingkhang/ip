/**
 * Subclass of Task class.
 * Includes the name of the task.
 */
public class Todo extends Task {
    /**
     * Constructor for Todo instance.
     *
     * @param description Name of todo task.
     */
    public Todo(String description) {
        super(description, TaskType.Todo);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Formats Todo for saving.
     *
     * @return String Formatted details of Todo.
     */
    @Override
    public String saveDetails() {
        return "T | " + super.saveDetails();
    }
}
