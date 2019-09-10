public class Parser {

    String[] parse(String cmd) throws ArrayIndexOutOfBoundsException, NumberFormatException {

        return cmd.split("\\s", 2);

    }
}
