
public class List {
    String[] items = new String[100];
    private int size = 0;

    void addItem(String item) {
       items[size] = item;
       size++;

       Duke.drawLine(20);
       System.out.println("Added: " + item);
       Duke.drawLine(20);

    }

    void printItems() {
        Duke.drawLine(20);
        for (int i = 1; i <= size; i++) {
           System.out.println(size + "." + items[i-1]);
        }
        Duke.drawLine(20);
    }
}
