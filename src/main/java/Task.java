class Task {
    private boolean done = false;
    private String item;
    static int totalTasks = 0;

    Task(String toAdd) {
        item = toAdd;
        totalTasks++;
    }

    /**
     * Converts the date and time as a string int 24hr format into a DateTime object
     * @param date String of a date and time in the form of "DD/MM/YYYY HHMM"
     * @return a new DateTime object corresponding to the input date and time.
     */
    DateTime str_to_DateTime(String date) {
        String[] date_tok = date.split(" ");
        return new DateTime(date_tok[0], date_tok[1]);

    }

    static int  getTotalTasks() {
        return totalTasks;
    }

    String getItem() {
        return item;
    }

    boolean isDone() {
        return done;
    }

    void setDone() {
        done = true;
    }

    public String toString() {
        String doneOp = done ? "Y" : "N";
        return "[" + doneOp + "] " + item;
    }
}

