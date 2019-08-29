import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

class List {

    private Task[] items = new Task[100];

    void addItem(String item, TASKTYPE type) {
        if (type == TASKTYPE.EVENT) {
            String[] splitItem = item.split(" /at ");
            items[Task.getTotalTasks()] = new Event(splitItem[0], splitItem[1]);
        }

        else if (type == TASKTYPE.DEADLINE) {
            String[] splitItem = item.split(" / ");

            items[Task.getTotalTasks()] = new Deadline(splitItem[0], splitItem[1]);
        }

        else {
            items[Task.getTotalTasks()] = new ToDo(item);
        }

        System.out.println("You now have " + Task.getTotalTasks() + " items in the list.");

    }

    void savetoFile() {
        Path file = Paths.get("data/duke.txt");

        try {

            if (!Files.exists(file)) {
                Files.createFile(file);
            }

            BufferedWriter writer = Files.newBufferedWriter(file);
            for (int i = 0 ; i < Task.getTotalTasks() ; i++) {
                StringBuilder sb = new StringBuilder();
                Task obj = items[i];
                sb.append(obj.getItem());

                if (obj instanceof ToDo) {
                    sb.insert(0,"T | ");

                }

                else if (obj instanceof Deadline) {
                    sb.insert(0, "D | ");
                    sb.append(" | ").append(((Deadline) obj).getDate());
                }

                else if (obj instanceof Event) {
                    sb.insert(0, "E | ");
                    sb.append(" | ").append(((Event) obj).getDuration());
                }

                writer.write(sb.toString());
                writer.newLine();

            }

            writer.close();

            System.out.println("Successfully saved to " +file.toString());
        }

        catch (IOException e) {
            System.err.format("IO Exception: %s%n", e);
        }


    }

    void checkOff(int itemnum) {
        if (itemnum <= Task.getTotalTasks()) {
            items[itemnum - 1].setDone();
        }
        System.out.println("Nice! I've marked the task as done:");
        System.out.println("[Y] " + items[itemnum-1].getItem());
    }

    public String toString() {
        int size = Task.getTotalTasks();
        if (size == 0) {
            return "No tasks added";
        }

        else {
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= size; i++) {
                str.append(i).append(". ").append(items[i - 1]).append("\n");
            }

            return str.toString();
        }
    }
}
