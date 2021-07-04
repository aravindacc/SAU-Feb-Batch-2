import java.util.LinkedList;
import java.util.Queue;

class PC extends Thread {
    Queue<Integer> queue;
    int maxSize;

    public PC(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void produce() throws InterruptedException{
        int value = 1;
        System.out.println("Producer is Producing");
        while(true) {
            synchronized (this) {
                while(this.queue.size() >= maxSize) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Queue is Full. Waiting for Consumer to consume");
                    System.out.println("----------------------------------------------");
                    wait();
                }

                System.out.println("----------------------------------------------");
                System.out.println("Producer Produced " + (value));
                System.out.println("----------------------------------------------");
                queue.add(value);
                value++;
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while(queue.size() == 0) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Queue is Empty. Waiting for Producer to produce");
                    System.out.println("----------------------------------------------");
                    wait();
                }
                int val = queue.poll();
                System.out.println("----------------------------------------------");
                System.out.println("Consumer Consumed " + val);
                System.out.println("----------------------------------------------");
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException{
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<6;i++) {
            queue.add(i);
        }
        int maxSize = 5;
        final PC pc = new PC(queue, maxSize);

        // Consumer Thread
        new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
        }).start();

        // Producer Thread
        new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
        }).start();
    }
}
