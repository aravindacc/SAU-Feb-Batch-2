package assignment1;

import java.util.*;

public class ProducerConsumer_problem {
    public static void main(String[] args) {

        // Capacity of the items list = 5
        int initialcap = 5;
        // Taking a queue of length 5
        ArrayList<Integer> items = new ArrayList<>(5);

        // Taking some items in the items list initially
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(3);
        items.add(3);

        System.out.println("Number of items in list initially = " + items.size());
        Producer obj_pro = new Producer(items, initialcap);
        Consumer obj_cons = new Consumer(items, initialcap);

        // Starting the producer thread
        obj_pro.start();

        // Starting the consumer thread
        obj_cons.start();


    }
}
