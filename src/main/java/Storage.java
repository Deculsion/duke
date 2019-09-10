import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Storage {

    /**
     * Loads the saved task list from file.
     * Should be run at start up and returns a List object with empty taskList if file doesn't exist.
     */
      List loadfromFile() {
        List obj = new List();
        Path file = Paths.get("data/duke.txt");

        try {
            if (!Files.exists(file)) {
                return obj;
            }

            BufferedReader reader = Files.newBufferedReader(file);

            String line;
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split(" \\| ");

                System.out.println(Arrays.toString(tokens));

                switch (tokens[0]) {
                    case "T":
                        obj.addItem(tokens[1], TASKTYPE.TODO);
                        break;

                    case "D":
                        obj.addItem(tokens[1] + " /by " + tokens[2], TASKTYPE.DEADLINE);
                        break;

                    case "E":
                        obj.addItem(tokens[1] + " /at " + tokens[2], TASKTYPE.EVENT);
                        break;
                }

                if (tokens[tokens.length - 1].equals("1")){
                    obj.checkOff(Task.getTotalTasks(), false);
                }

            }

            reader.close();

        }

        catch (IOException e) {
            System.err.format("IO Exception: %s%n", e);
        }

        return obj;

    }

    /**
     * Saves the current tasklist to file. Automatically called after every command.
     * If no existing file is found, it will be created.
     */
    void savetoFile(List tasks) {
        Path file = Paths.get("data/duke.txt");

        try {
            if (!Files.exists(Paths.get("data/duke"))) {
                Files.createDirectories(Paths.get("data/duke"));
            }

            if (!Files.exists(file)) {
                Files.createFile(file);
            }

            BufferedWriter writer = Files.newBufferedWriter(file);
            for (int i = 0 ; i < Task.getTotalTasks() ; i++) {
                StringBuilder sb = new StringBuilder();
                Task obj = tasks.getTask(i);
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
}
