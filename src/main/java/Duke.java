/**
 * Main class of Duke. Starts the entire program.
 *
 */

public class Duke {
    /**
     * @param args This class doesn't do anything meaningful with args yet.
     */
    public static void main(String[] args) {

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

        echoLine echo = new echoLine();

    }

    static void drawLine(int length) {

        for (int i  = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
