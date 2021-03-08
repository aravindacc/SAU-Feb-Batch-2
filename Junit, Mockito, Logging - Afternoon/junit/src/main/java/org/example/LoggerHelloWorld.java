package org.example;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class LoggerHelloWorld {

    /* Get the class name to be printed on */
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args)throws IOException,SQLException{
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}