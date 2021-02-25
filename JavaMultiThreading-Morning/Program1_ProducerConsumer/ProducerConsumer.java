import java.util.*;
import java.util.LinkedList; 
public class ProducerConsumer 
{ 
	public static void main(String[] args) 
	{ 
		List<Integer> queue=new ArrayList<Integer>();

		//Producer thread to produce the amount
		Thread thread1 = new Thread(new Producer(queue));
		//Consumer thread to consume the amount
		Thread thread2 = new Thread(new Consumer(queue));
		//start both the threads
		thread1.start();
		thread2.start();
	
	} 
} 
//Producer class
class Producer implements Runnable
{
	List<Integer> queue = null;//initially
	final int MAX_SIZE = 4;//size of the queue
	private int amount = 100;
	//constrcutor for produce class
	public Producer(List<Integer> queue)
	{
		super();
		this.queue=queue;
	}

	//@override
	public void run()
	{
		while(true)
		{
			try
			{
				amount=amount+amount;
				produce(amount);
			}
			catch(InterruptedException exception)
			{

			}
		}
	}

	public void produce(int amount) throws InterruptedException
	{
		synchronized(queue)
		{
			//if queue is full then wait
			while(queue.size() == MAX_SIZE)
			{
				System.out.println("queue is full..waiting for the consumer to consume the amount");
				queue.wait();
			}
		}

		synchronized(queue)
		{
			//if queue is not full then add
			System.out.println("Producer produced amount " + amount);
			queue.add(amount);
			Thread.sleep(10);
			queue.notify();
		}
	}
}
//Consumer class
class Consumer implements Runnable
{
	List<Integer> queue = null;

	//constrcutor for consumer class
	public Consumer(List<Integer> queue)
	{
		super();
		this.queue=queue;
	}

	//@override
	public void run()
	{
		while(true)
		{
			try
			{
				consume();
			}
			catch(InterruptedException exception)
			{
				
			}
		}
	}

	public void consume() throws InterruptedException
	{
		synchronized(queue)
		{
			//if queue is empty then wait
			while(queue.isEmpty())
			{
				System.out.println("queue is empty..waiting for the producer to produce the amount");
				queue.wait();
			}
		}

		synchronized(queue)
		{
			Thread.sleep(1000);
			System.out.println("Consumer consumed amount " + queue.remove(0));
			queue.notify();
		}
	}
}