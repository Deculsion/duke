/**
 * Echos the command input by the user.
 */

import java.util.Scanner;

public class echoLine extends Duke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String echo = input.next();

        Duke.drawLine(20);
        System.out.println(echo);
        Duke.drawLine(20);

    }
}
