class Deadline extends Task {
    private String date;

    Deadline(String toAdd, String date) {
        super(toAdd);
        this.date = date;
    }

    String getDate() {
        return date;
    }
}
