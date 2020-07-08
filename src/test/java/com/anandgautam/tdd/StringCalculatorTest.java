package com.anandgautam.tdd;

import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {

    /* Test Blank String input */
    public void testAddZeroNumber() {
        assertEquals(0, new StringCalculator().Add(""));
    }

    /* Test a single string input*/
    public void testAddOneNumber() {
        int inputNumber = 5;
        assertEquals(inputNumber, new StringCalculator().Add(String.valueOf(inputNumber)));
    }

    public void testAddTwoNumber() {
        assertEquals(5, new StringCalculator().Add("2,3"));
    }

}