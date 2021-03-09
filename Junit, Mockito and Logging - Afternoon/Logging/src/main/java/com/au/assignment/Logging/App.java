package com.au.assignment.Logging;

/**
 * Hello world!
 *
 */
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	static Logger log = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		log.info("This is a function which checks if number is Prime or Not for 1 to 100");

		for (int i = -1; i <= 101; i++) {
			if (i < 0)
				log.fatal("you cannot input negative number");
			else if (i == 0)
				log.warn("0 is neither prime nor composite");
			else if (i > 100)
				log.error("Number is greater than 100");
			else
				log.debug(i + " is Prime --------> " + isPrime(i));
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}
}