/**
 * Main class of Duke. Starts the entire program.
 *
 */

import java.util.Scanner;

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
            String[] cleanedCmd = command.split(" ", 2);
            if (cleanedCmd[0].equals("list")){
                taskList.printItems();
            }

            else if(cleanedCmd[0].equals("done")){
                taskList.checkOff(Integer.parseInt(cleanedCmd[1]));
            }

            else {
                taskList.addItem(cleanedCmd[0] + " " +cleanedCmd[1]);
            }
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
