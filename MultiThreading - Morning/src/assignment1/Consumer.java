package assignment1;
import java.util.*;
public class Consumer extends Thread {

    int capacity = 5;
    ArrayList<Integer> items = new ArrayList<>(5);
    int consumed_item = 0;

    public Consumer(ArrayList<Integer> items, int capacity) {
        // Consumer list initialized with main list of items
        this.items = items;
        this.capacity = capacity;

    }

    public void run () {

        System.out.println("Consumer Thread");
        while (true) {
            while(items.size() == 0) {
                synchronized (items) {
                    try {
                        Thread.sleep(50);
                        System.out.println("Nothing to consume. Add some items");
                        // Consumer can't consume anything as the list is empty.
                        // Notify the producer to start producing items
                        items.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (items) {
                items.notify();

                // Consumer consume's first item in the list.
                consumed_item = items.get(0);
                items.remove(0);

                System.out.println("Consumer consumed = " + (consumed_item));
                System.out.println("Remaining Items = " + items.size());
            }
        }
    }
}

