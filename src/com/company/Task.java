package com.company;
import java.util.Date;

/**
 * <h1>Task</h1>
 * The task class stores the name, description and dueDate for a task.
 * Task also handles formatting the data as a single-line string and
 * as a more in-depth multiline format
 *
 * @author HKing
 * @version 1.0
 * @since 2-3-2021
 */
public class Task {
    private String name;
    private String description;
    private Date dueDate;

    /**
     * Initializes a Task with a due date
     * @param name Name of the Task
     * @param desc Description of the Task
     * @param dueDate Due Date of the Task as a Date object
     */
    public Task(String name, String desc, Date dueDate) {
        this.name = name;
        this.description = desc;
        this.dueDate = dueDate;
    }

    /**
     * Initializes a Task without a due date
     * @param name Name of the Task
     * @param desc Description of the Task
     */
    public Task(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.dueDate = null;
    }

    /**
     * @return Name of the Task
     */
    public String getName() {
        return name;
    }

    /**
     * @return Description of the Task
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Due Date of the Task
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the name of the Task, fails if null.
     * @param name New name of the Task
     */
    public void setName(String name) {
        if (name != null) this.name = name;
    }

    /**
     * Sets the description of the Task
     * @param description New description of the Task
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets a new Due Date for the Task, fails if null.
     * @param dueDate New Due Date of the Task
     */
    public void setDueDate(Date dueDate) {
        if (name != null) this.dueDate = dueDate;
    }

    /**
     * <h2>Display Format</h2>
     * Formats the Task with the name, description and due date
     * Wraps each line in description to 100 characters
     *
     * @return The formatted display String
     */
    public String toDisplay() {
        int lineChars = 100;
        final StringBuilder sb = new StringBuilder();
        sb.append("---").append(name).append("---\n");

        if (description == null) {sb.append("No Description");}
        else {
            int charsPrinted = 0;
            for (int n = 0; n < description.length(); n += lineChars) {
                String rest = description.substring(n);
                if (rest.length() < lineChars) sb.append(rest);
                else sb.append(rest, 0, lineChars);
            }
        }
        if (dueDate != null) {
            sb.append("Due Date: ").append(dueDate);
        }
        return sb.toString();
    }

    /**
     * Formats the Task as a single line
     * Example: {@code ExampleTask - Wed Feb 3 02:28:00 EST 2021}
     * @return The formatted String
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (dueDate != null) {
            sb.append(" - ");
            sb.append(dueDate);
        }
        return sb.toString();
    }
}
