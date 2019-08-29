public class Event extends Task {
    private String duration;

    Event(String toAdd, String duration) {
        super(toAdd);
        this.duration = duration;
    }

    public String toString() {
        return "[E]" + super.toString() + "(at: " + duration + ")";
    }

    String getDuration() {
        return duration;
    }

}
