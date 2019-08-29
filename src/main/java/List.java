import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

class List {

    private Task[] items = new Task[100];

    List() {
        loadfromFile();
    }

    void addItem(String item, TASKTYPE type) {

        try {
            if (type == TASKTYPE.EVENT) {
                String[] splitItem = item.split(" /at ");
                items[Task.getTotalTasks()] = new Event(splitItem[0], splitItem[1]);
            } else if (type == TASKTYPE.DEADLINE) {
                String[] splitItem = item.split(" /by ");

                items[Task.getTotalTasks()] = new Deadline(splitItem[0], splitItem[1]);
            } else {
                items[Task.getTotalTasks()] = new ToDo(item);
            }

            System.out.println("You now have " + Task.getTotalTasks() + " items in the list.");
        }

        catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("OOPS!! Deadline and Events must have /by and /at tags respectively");
        }


    }

    private void loadfromFile() {
        Path file = Paths.get("data/duke.txt");

        try {
            if (!Files.exists(file)) {
                return;
            }

            BufferedReader reader = Files.newBufferedReader(file);

            String line;
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split(" \\| ");

                System.out.println(Arrays.toString(tokens));

                switch (tokens[0]) {
                    case "T":
                        addItem(tokens[1], TASKTYPE.TODO);
                        break;

                    case "D":
                        addItem(tokens[1] + " /by " + tokens[2], TASKTYPE.DEADLINE);
                        break;

                    case "E":
                        addItem(tokens[1] + " /at " + tokens[2], TASKTYPE.EVENT);
                        break;
                }

                if (tokens[tokens.length - 1].equals("1")){
                    items[Task.getTotalTasks() - 1].setDone();
                }

            }

            reader.close();

        }

        catch (IOException e) {
            System.err.format("IO Exception: %s%n", e);
        }

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
                    sb.append(" | ").append(((Deadline) obj).getDate_short());
                }

                else if (obj instanceof Event) {
                    sb.insert(0, "E | ");
                    sb.append(" | ").append(((Event) obj).getDuration_short());
                }

                if (obj.isDone()) {
                    sb.append (" | ").append("1");
                }

                else {
                    sb.append(" | ").append("0");
                }

                writer.write(sb.toString());
                writer.newLine();

            }

            writer.close();

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
