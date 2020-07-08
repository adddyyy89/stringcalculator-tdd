package com.anandgautam.tdd;

import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {

    /* Test Blank String input */
    public void testAddZeroNumber() {
        assertEquals(0, new StringCalculator().Add(""));
    }

    /* Test a single string input*/
    public void testAddOneNumber() {
        assertEquals(5, new StringCalculator().Add(String.valueOf(5)));
        assertEquals(2, new StringCalculator().Add("2,"));
    }

    /* Test two numbers */
    public void testAddTwoNumber() {
        assertEquals(5, new StringCalculator().Add("2,3"));
    }

}