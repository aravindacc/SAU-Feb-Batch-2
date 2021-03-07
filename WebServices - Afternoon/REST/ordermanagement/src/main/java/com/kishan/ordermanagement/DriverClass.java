
package com.kishan.ordermanagement;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



//@SpringBootApplication
//public class DriverClass {
//
//	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(DriverClass.class);
//	    app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//	    app.run(args);
//	}
//}


//This annotation is to be used only once in our application where we use the run method
//This is to tell the jvm that it is the starting point of our application
@SpringBootApplication
@ComponentScan(basePackages = {"com.kishan.ordermanagement"})
public class DriverClass {
 public static void main(String[] args) {
     // this is to tell the jvm to run our application
     SpringApplication.run(DriverClass.class, args);
 }
}
