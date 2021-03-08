package org.example;

import junit.framework.TestCase;

public class JavaTest extends TestCase {
    int value1,value2;

    public void testString() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
    public void setUp()
    {
        value1=value2=3;
    }

    public void testAdd(){
        double res=value1+value2;
        assertTrue(res==6);
    }
}


