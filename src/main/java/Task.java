class Task {
    private boolean done = false;
    String item;
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
}

