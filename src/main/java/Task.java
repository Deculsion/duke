class Task {
    private boolean done = false;
    private String item;
    static int totalTasks = 0;

    Task(String toAdd) {
        item = toAdd;
        totalTasks++;
    }

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

