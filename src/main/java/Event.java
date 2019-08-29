public class Event extends Task {
    private DateTime from;
    private DateTime to;

    Event(String toAdd, String duration) {
        super(toAdd);
        String[] dates = duration.split(" to ");
        from = str_to_DateTime(dates[0]);
        to = str_to_DateTime(dates[1]);
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + from.toString() + " to " + to.toString() + " )" ;

    }

    String getDuration() {
        return from.toString() + " to " + to.toString();
    }

    String getDuration_short() {
        return from.getDate_short() + " to " + to.getDate_short();
    }

}
