package com.au.assignment.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import com.au.assignment.Mockito.mockito.PrimeChecker;
import com.au.assignment.Mockito.mockito.PrimeController;

/**
 * Hello world!
 *
 */
	public class AppTest {
		PrimeController pc;
		@Before
		public void setup() {
			PrimeChecker pc1 = mock(PrimeChecker.class);
			when(pc1.isPrime(1)).thenReturn(false);
			when(pc1.isPrime(2)).thenReturn(true);
			pc = new PrimeController();
			pc.setObj(pc1);
		}
		
		@org.junit.Test
		public void test1() {
			Assert.assertEquals(false, pc.Prime(1));
		}
		
		@org.junit.Test
		public void test2() {
			Assert.assertEquals(true, pc.Prime(2));
		}
		
		

	}

