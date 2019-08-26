public class Event extends Task {
    private String duration;

    Event(String toAdd, String duration) {
        super(toAdd);
        this.duration = duration;
    }

    public String toString() {
        return "[D]" + super.toString() + "(at: " + duration + ")";
    }

}
