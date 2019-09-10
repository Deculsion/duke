import java.lang.reflect.Array;
import java.util.Scanner;

public class UI {
    public void welcome() {
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
    }

    void goodbye() {
        drawLine(20);
        System.out.println("Bye. Hope to see you again soon!");
        drawLine(20);
    }


    void printOutOfBoundException (ArrayIndexOutOfBoundsException e, String command) {
        System.err.format("OOB exception: %s%n", e);
        System.out.println("OOPS!!! The description of " + command + " cannot be empty.");
    }

    void printUnknownCommandException() {
        System.out.println("OOPS!!! I don't know what you mean.");
    }

    void printNumberFormatException() {
        System.out.println("OOPS!!! Please enter the number of the item to delete.");
    }

    public String[] takeInput() throws ArrayIndexOutOfBoundsException, NumberFormatException{
        Parser parser = new Parser();
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        String[] cmd = parser.parse(command);

        return cmd;
    }

    /**
     * Draws a line across the screen
     *
     * @param length Number of characters to draw
     */
    static void drawLine(int length) {

        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
