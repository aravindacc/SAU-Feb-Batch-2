package com.demo.logging;

import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {

	static Logger log = LogManager.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		for(int i = 0 ; i < 25; i++){
			log.debug("Number is "+i);
		}
		log.error("16 is not Divisible By 5 (16%5) "+ 16%5);
		log.fatal("You cannot login without Username");
		log.info("16 is a Even Number (16%2) "+16%2);
		log.warn("15 can't be divided by 0 (15/0) "+15/0);
	}

}
