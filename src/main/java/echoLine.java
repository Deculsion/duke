/**
 * Echos the command input by the user.
 */

import java.util.Scanner;

public class echoLine {
     static boolean echo() {
        Scanner input = new Scanner(System.in);

        String echo = input.next();

        if (echo.toLowerCase().equals("bye")) {
            return false;
        }

        Duke.drawLine(20);
        System.out.println(echo);
        Duke.drawLine(20);
        return true;
    }
}
