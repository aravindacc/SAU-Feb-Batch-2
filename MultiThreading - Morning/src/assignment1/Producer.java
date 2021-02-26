package assignment1;
import java.util.*;
public class Producer extends Thread {

    int newitem = 1;
    int capacity = 5;
    ArrayList<Integer> items = new ArrayList<>();

    public Producer(ArrayList<Integer> items, int capacity) {
        // Update the producer's list of items with the main list
        this.items = items;
        this.capacity = capacity;
    }
    public void run () {

        System.out.println("Producer Thread");
           // Using while true so that producer keeps on producing when there's a vacant space in list
            // and similarly in consumer, it keeps consuming when there's atleast one element in list.
            while(true) {
                while(items.size() == capacity) {
                    synchronized (items) {
                        try {
                            Thread.sleep(5000);
                            System.out.println("Cannot produce more items. List is full");
                            // Wait for the consumer to consume items
                            items.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (items) {
                    items.add(newitem);
                    items.notify();
                }
                System.out.println("Producer produced = " + (newitem++));
                System.out.println("Remaining Items = " + items.size());
            }
    }
}
