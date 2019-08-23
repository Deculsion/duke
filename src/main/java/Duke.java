/**
 * Main class of Duke.
 *
 */

public class Duke {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";

        drawLine(20);
        System.out.println("Hello from\n" + logo);
        drawLine(20);
        System.out.println();

    }

    static void drawLine(int length) {

        for (int i  = 0; i < length ; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
