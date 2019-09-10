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
        String[] command ={"", ""};
        Storage fileIO = new Storage();
        List taskList = fileIO.loadfromFile();
        UI ui = new UI();

        ui.welcome();

        while (!command[0].equals("bye")) {
            UI.drawLine(20);
            try {
                command = ui.takeInput();

                switch (command[0]) {
                    case "list":
                        System.out.println(taskList);
                        break;

                    case "event":
                        taskList.addItem(command[1], TASKTYPE.EVENT);
                        break;

                    case "deadline":
                        taskList.addItem(command[1], TASKTYPE.DEADLINE);
                        break;

                    case "todo":
                        taskList.addItem(command[1], TASKTYPE.TODO);
                        break;

                    case "done":
                        taskList.checkOff(Integer.parseInt(command[1]), true);
                        break;

                    case "save":
                        fileIO.savetoFile(taskList);
                        break;

                    case "delete":
                        taskList.removeItem(Integer.parseInt(command[1]));
                        break;

                    case "find":
                        taskList.find_tasks(command[1]);
                        break;

                    default:
                        throw new UnknownCommandException();
                }

                fileIO.savetoFile(taskList);
            }

            catch (ArrayIndexOutOfBoundsException e) {
                ui.printOutOfBoundException(e, command[0]);
            }

            catch (UnknownCommandException e) {
                ui.printUnknownCommandException();
            }

            catch (NumberFormatException e) {
                ui.printNumberFormatException();
            }

            UI.drawLine(20);
        }

        ui.goodbye();

    }

    /**
     * Draws a line across the screen
     * @param length Number of characters to draw
     */
    static void drawLine(int length) {

        for (int i  = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
