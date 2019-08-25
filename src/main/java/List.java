
class List {
    private Task[] items = new Task[100];

    void addItem(String item) {
       Task newTask = new Task(item);
       items[Task.getTotalTasks() - 1] = newTask;

       Duke.drawLine(20);
       System.out.println("Added: " + item);
       Duke.drawLine(20);

    }

    void printItems() {
        Duke.drawLine(20);
        int size = Task.getTotalTasks();
        if (size == 0) {
            System.out.println("No tasks added");
        }

        else {
            for (int i = 1; i <= size; i++) {
                String checkmark = items[i-1].isDone() ? "Y" : "N";
                System.out.println(i + ".[" + checkmark + "] "+ items[i - 1].getItem());
            }
        }
        Duke.drawLine(20);
    }

    void checkOff(int itemnum) {
        if (itemnum <= Task.getTotalTasks()) {
            items[itemnum - 1].setDone();
        }

        Duke.drawLine(20);
        System.out.println("Nice! I've marked the task as done:");
        System.out.println("[Y] " + items[itemnum-1].getItem());
        Duke.drawLine(20);

    }
}
