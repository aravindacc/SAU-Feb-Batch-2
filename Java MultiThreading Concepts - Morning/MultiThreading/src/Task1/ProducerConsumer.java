package Task1;

import Task1.models.Employee;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer
{
    private Queue<Employee> employeeList = new LinkedList<>();
    private int max_size = 10;

    public int getEmployeeListSize() {
        return employeeList.size();
    }

    public synchronized boolean addEmployee(Employee employee)
    {
        //Thread which is going to Add Employee
        System.out.println(Thread.currentThread().getName()+" is going to Add Employee if the Queue is not full");
        if(employeeList.size() >= max_size)
        {
            try{
                System.out.println("Waiting for Consumer To Consume Data From The Queue");
                Thread.sleep(1000);
                wait();
                /**
                 * As two threads are started at a time, when the thread try to Add Employee if the queue is already full it gets
                 * it waits until the Consumer consumes and removes data and make space for new employee to be added in the queue
                 */
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted exception has occurred");
            }
        }
        employeeList.add(employee);
        max_size += 1;
        System.out.println("Added Employee To The Queue");
        notify();
        return true;
    }

    public synchronized boolean removeEmployee()
    {
        //Thread which is going to Remove Employee
        System.out.println(Thread.currentThread().getName()+" is going to Remove Employee if the Queue is not empty");
        if(employeeList.size() == 0)
        {
            try{
                System.out.println("Waiting for Producer To Produce Data To The Queue");
                Thread.sleep(1000);
                wait();
                /**
                 * As two threads are started at a time, when the thread try to Remove Employee if the queue is already empty it gets
                 * it waits until the Producer produces and adds data to be removed from the queue
                 */

            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted exception has occurred");
            }
        }
        employeeList.poll();
        max_size -= 1;
        System.out.println("Removed Employee From The Queue");
        notify();
        return true;
    }
}