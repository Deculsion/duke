
class List {
    private Task[] items = new Task[100];

    void addItem(String item) {
        Task newTask = new Task(item);
        items[Task.getTotalTasks() - 1] = newTask;

        System.out.println("Added: " + item);

    }

    public String toString() {
        int size = Task.getTotalTasks();
        if (size == 0) {
            return "No tasks added";
        }

        else {
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= size; i++) {
                str.append(i).append(". ").append(items[i - 1]).append("\n");
            }

            return str.toString();
        }
    }

    void checkOff(int itemnum) {
        if (itemnum <= Task.getTotalTasks()) {
            items[itemnum - 1].setDone();
        }
        System.out.println("Nice! I've marked the task as done:");
        System.out.println("[Y] " + items[itemnum-1].getItem());
    }
}
