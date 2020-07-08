package com.anandgautam.tdd;

import org.junit.Test;

import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {

    /* Test Blank String input */
    public void testAddZeroNumber() throws NegativeNumberException {
        assertEquals(0, new StringCalculator().Add(""));
    }

    /* Test a single string input */
    public void testAddOneNumber() throws NegativeNumberException {
        assertEquals(5, new StringCalculator().Add(String.valueOf(5)));
        assertEquals(2, new StringCalculator().Add("2,"));
    }

    /* Test two numbers */
    public void testAddTwoNumber() throws NegativeNumberException {
        assertEquals(2 + 3, new StringCalculator().Add("2,3"));
    }

    /* Test multiple numbers */
    public void testAddMultpleNumbers() throws NegativeNumberException {
        assertEquals(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9, new StringCalculator().Add("1,2,3,4,5,6,7,8,9"));
        assertEquals(1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1, new StringCalculator().Add("1,1,1,1,1,1,1,1,1"));
    }

    /* Test new line between numbers */
    public void testAddNewLineBetweenNumbers() throws NegativeNumberException {
        assertEquals(1 + 2 + 3, new StringCalculator().Add("1\n2,3"));
        assertEquals(1 + 2 + 3, new StringCalculator().Add("1\n2\n3"));
    }

    /* Test different delimiters */
    public void testAddDifferentDelimiters() throws NegativeNumberException {
        assertEquals(1 + 2, new StringCalculator().Add("//;\n1;2"));
        assertEquals(1 + 2 + 3, new StringCalculator().Add("//&\n1&2&3"));
    }

    @Test
    public void testAddNegativeNumbers() {
        try {
            new StringCalculator().Add("//;\n-1");
        } catch (NegativeNumberException e) {
            assertEquals("negative numbers are not allowed : [-1]", e.getMessage());
        }


        try {
            new StringCalculator().Add("//&\n-1&2&-3");
        } catch (NegativeNumberException e) {
            assertEquals("negative numbers are not allowed : [-1, -3]", e.getMessage());
        }
    }

}