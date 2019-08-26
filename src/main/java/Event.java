public class Event extends Task {
    private String start;
    private String end;

    Event(String toAdd, String start, String end) {
        super(toAdd);
        this.start = start;
        this.end = end;
    }
}
