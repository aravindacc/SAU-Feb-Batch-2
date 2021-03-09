package com.au.assignment.Junit;

import static org.junit.Assert.assertEquals;

/**
 * Hello world!
 *
 */
import org.junit.Test;

public class App 
{

	public void main(String[] args) 
	
	{

		try {
			for (int i = 1; i <= 100; i++) 
			{
				if (isPrime(i)) 
				{
					throw new ArithmeticException("Prime Number Found: " + i);
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Prime Number");
		}

	}

	public boolean isPrime(int num) {

		for (int i = 2; i < num ; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		App p = new App();
		boolean op1 = p.isPrime(15);
		assertEquals(false, op1);
		boolean op2 = p.isPrime(8);
		assertEquals(false, op2);
		boolean op3 = p.isPrime(11);
		assertEquals(true, op3);
	}

}