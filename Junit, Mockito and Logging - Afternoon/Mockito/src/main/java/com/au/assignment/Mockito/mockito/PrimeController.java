package com.au.assignment.Mockito.mockito;

public class PrimeController 
{
		PrimeChecker pc;
		public boolean Prime(int n) {
			return pc.isPrime(n);
		}
		public PrimeChecker getObj() {
			return pc;
		}
		public void setObj(PrimeChecker pc) {
			this.pc = pc;
		}
}
