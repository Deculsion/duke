class Task {
    private boolean done = false;
    private String item;
    private static int totalTasks = 0;

    Task(String toAdd) {
        item = toAdd;
        totalTasks++;
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
