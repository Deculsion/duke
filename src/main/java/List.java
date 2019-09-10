import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.ArrayList;


class List {

    private ArrayList<Task> items = new ArrayList<Task>();

    List() {
    }

    /**
     * Adds an item of specified type enum to the task list.
     * @param item The content of the task to add
     * @param type The enum of TASKTYPE to add
     */
    void addItem(String item, TASKTYPE type) {

        try {
            if (type == TASKTYPE.EVENT) {
                String[] splitItem = item.split(" /at ");
                items.add(new Event(splitItem[0], splitItem[1]));
            } else if (type == TASKTYPE.DEADLINE) {
                String[] splitItem = item.split(" /by ");

                items.add(new Deadline(splitItem[0], splitItem[1]));
            } else {
                items.add(new ToDo(item));
            }

            System.out.println("You now have " + Task.getTotalTasks() + " items in the list.");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("OOPS!! Deadline and Events must have /by and /at tags respectively");
        }


    }

    /**
     * Deletes an item from the task list
     * @param index List number item to delete.
     */
    void removeItem(int index) {
        if (index > items.size()) {
            System.out.println("OOPS!! The list is not that large!");
            return;
        }

        else if (index <= 0) {
            System.out.println("OOPS!! Please enter a number larger than 0.");
            return;
        }

        Task obj = items.get(index - 1);
        obj = null;
        items.remove(index - 1);
        Task.totalTasks--;

        System.out.println("The item has been removed from the list.");
    }

    /**
     * Searches and returns all tasks that matches query.
     * @param query String representing the search term.
     */
    void find_tasks(String query) {
        ArrayList<Integer> foundItems = new ArrayList<Integer>();
        for (int i = 0 ; i < items.size() ; i++) {
            if (items.get(i).getItem().contains(query)) {
                foundItems.add(i);
            }
        }

        if (foundItems.isEmpty()) {
            System.out.println("Sorry, the item cannot be found in the list.");
            return;
        }

        int i = 1;
        for (Integer index : foundItems) {
            System.out.println(i++ + ". " + items.get(index).toString());
        }

    }

    /**
     * Sets the specified task as complete.
     * @param itemnum The list number of the item to check off.
     */
    void checkOff(int itemnum, boolean UI) {
        if (itemnum <= Task.getTotalTasks()) {
            items.get(itemnum - 1).setDone();
        }

        if (UI) {
            System.out.println("Nice! I've marked the task as done:");
            System.out.println("[Y] " + items.get(itemnum - 1).getItem());
        }
    }

    Task getTask(int i) {
        return items.get(i);
    }

    public String toString() {
        int size = Task.getTotalTasks();
        if (size == 0) {
            return "No tasks added";
        }

        else {
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= size; i++) {
                str.append(i).append(". ").append(items.get(i-1)).append("\n");
            }

            return str.toString();
        }
    }
}
