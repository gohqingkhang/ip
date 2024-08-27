package delta.util;

import delta.task.Task;

import delta.exception.DeltaException;

import java.util.ArrayList;

/**
 * Contains all the tasks in a list.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Overloaded constructor to create instance using saved tasks.
     * Only used by constructor of Delta.java.
     *
     * @param tasks Saved list of tasks to be stored in TaskList.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns a specific task from the list indicated by index.
     *
     * @param index Index of task to be returned.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Returns size of list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds task into stored list.
     *
     * @param task Task to be added into list.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks specific task in list as done.
     *
     * @param index Index of task to be marked.
     * @return Task after it has been marked as done.
     * @throws DeltaException If list is empty, task not found in list or task is already marked as done.
     */
    public Task markTask(int index) throws DeltaException {
        if (tasks.isEmpty()) {
            throw new DeltaException("OOPS!!! List is empty, there is no task to mark.");
        } else if (index < 1 || index > tasks.size()) {
            throw new DeltaException("""
                    OOPS!!! Task not found in list.
                    \t Please provide a valid Task to mark.""");
        }
        Task task = tasks.get(index - 1);
        if (task.getStatusIcon().equals("X")) {
            throw new DeltaException("OOPS!!! Task is already marked as done.");
        }
        task.markAsDone();
        tasks.set(index - 1, task);
        return task;
    }

    /**
     * Marks specific task in list as not done yet.
     *
     * @param index Index of task to be unmarked.
     * @return Task after it has been unmarked.
     * @throws DeltaException If list is empty, task not found in list or task is already unmarked.
     */
    public Task unmarkTask(int index) throws DeltaException {
        if (tasks.isEmpty()) {
            throw new DeltaException("OOPS!!! List is empty, there is no task to unmark.");
        } else if (index < 1 || index > tasks.size()) {
            throw new DeltaException("""
                    OOPS!!! Task not found in list.
                    \t Please provide a valid Task to unmark.""");
        }
        Task task = tasks.get(index - 1);
        if (task.getStatusIcon().equals(" ")) {
            throw new DeltaException("OOPS!!! Task is already marked as not done yet.");
        }
        task.markAsNotDone();
        tasks.set(index - 1, task);
        return task;
    }

    /**
     * Removes specific task from list.
     *
     * @param index Index of task to be removed from list.
     * @return Task that was removed from list.
     * @throws DeltaException If list is empty or task not found in list.
     */
    public Task deleteTask(int index) throws DeltaException {
        if (tasks.isEmpty()) {
            throw new DeltaException("OOPS!!! List is empty, there is no task to delete.");
        } else if (index < 1 || index > tasks.size()) {
            throw new DeltaException("""
                    OOPS!!! Task not found in list.
                    \t Please provide a valid Task to delete.""");
        }
        Task task = tasks.get(index - 1);
        tasks.remove(index - 1);
        return task;
    }
}
