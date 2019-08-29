import java.util.Scanner;
/**
 * Main class of Duke. Starts the entire program.
 *
 */
public class Duke {

    /**
     * @param args This class doesn't do anything meaningful with args yet.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;
        List taskList = new List();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        drawLine(20);
        System.out.println("Hello I'm\n" + logo);
        System.out.println("How may I assist you?\n");
        drawLine(20);
        System.out.println();

        command = input.nextLine();

        while (!command.equals("bye")) {
            Duke.drawLine(20);
            try {
                String[] cleanedCmd = command.split("\\s", 2);

                switch (cleanedCmd[0]) {
                    case "list":
                        System.out.println(taskList);
                        break;

                    case "event":
                        taskList.addItem(cleanedCmd[1], TASKTYPE.EVENT);
                        break;

                    case "deadline":
                        taskList.addItem(cleanedCmd[1], TASKTYPE.DEADLINE);
                        break;

                    case "todo":
                        taskList.addItem(cleanedCmd[1], TASKTYPE.TODO);
                        break;

                    case "done":
                        taskList.checkOff(Integer.parseInt(cleanedCmd[1]));
                        break;

                    case "save":
                        taskList.savetoFile();
                        break;

                    default:
                        throw new UnknownCommandException();
                }

                taskList.savetoFile();
            }

            catch (ArrayIndexOutOfBoundsException e){
                System.err.format("OOB exception: %s%n", e);
                System.out.println("OOPS!!! The description of " + command + " cannot be empty.");
            }

            catch (UnknownCommandException e) {
                System.out.println("OOPS!!! I don't know what you mean.");
            }

            Duke.drawLine(20);
            command = input.nextLine();
        }

        drawLine(20);
        System.out.println("Bye. Hope to see you again soon!");
        drawLine(20);

    }

    static void drawLine(int length) {

        for (int i  = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
