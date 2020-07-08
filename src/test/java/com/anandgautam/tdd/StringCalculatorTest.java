package com.anandgautam.tdd;

import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {

    public void testAddZeroNumber() {
        assertEquals(0, new StringCalculator().Add(""));
    }

}