package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUnit2 {

    // Replace Hello with Robert here and it'll run
    //String message = "Hello";
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage() TestUnit2");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}