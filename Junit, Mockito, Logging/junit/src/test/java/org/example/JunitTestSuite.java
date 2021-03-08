package org.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses( {
        TestUnit1.class, TestUnit2.class
})

public class JunitTestSuite {
}