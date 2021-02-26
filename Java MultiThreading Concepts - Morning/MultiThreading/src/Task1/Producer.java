package Task1;

import Task1.models.Employee;

import java.util.LinkedList;
import java.util.Queue;

public class Producer {
    public static void main(String args[]) {

        final ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread() {
            public void run() {
                // Producer keeps producing data
                for(int i = 0 ; i < 100 ; i++){
                    Employee employee = new Employee();
                    producerConsumer.addEmployee(employee);
                    System.out.println("After adding employee the new Queue size is: " + producerConsumer.getEmployeeListSize());
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while(true){
                    producerConsumer.removeEmployee();
                    System.out.println("After removing employee the new Queue size is: " + producerConsumer.getEmployeeListSize());
                }
            }
        };

        // Inter thread communication between threads ,also called as producer and consumer
        // consumer will wait until , the producer produces (int consumer class - removeEmployee )
        t1.start();
        t2.start();
    }
}