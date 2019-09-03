class Deadline extends Task {
    private DateTime date;

    Deadline(String toAdd, String date) {
        super(toAdd);
        this.date = str_to_DateTime(date);
    }

    String getDate() {
        return date.toString();
    }

    String getDate_short() {
       return date.getDate_short();
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + date + ")";
    }
}
