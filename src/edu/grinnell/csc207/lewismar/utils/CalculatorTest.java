/*
 * @author Matt Dole
 * @author Mark Lewis
 * HW-3
 */
package edu.grinnell.csc207.lewismar.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigInteger;
public class CalculatorTest {

    @Test
    public void testEva10() {
    assertEquals("Addition of 2 positives", BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    assertEquals("Addition of 3 positives", BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals("Addition of 3 positives", BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals("Subtraction of 2 positives", BigInteger.valueOf(0), Calculator.eval0("1 - 1"));
    assertEquals("Subtraction of 3 positives", BigInteger.valueOf(-2), Calculator.eval0("1 - 2 - 1"));
    assertEquals("Subtraction of a positive and a negative", BigInteger.valueOf(2), Calculator.eval0("1 - -1"));
    assertEquals("Subtraction of 2 positives and multiplication by a positive", BigInteger.valueOf(-3), Calculator.eval0("1 - 2 * 3"));
    assertEquals("Division of positive integers", BigInteger.valueOf(4), Calculator.eval0("2 / 2 * 4"));
    assertEquals("Division of negative integers", BigInteger.valueOf(-4), Calculator.eval0("-2 / -2 * -4"));
    assertEquals("Division of positive and negative integers", BigInteger.valueOf(4), Calculator.eval0("-2 / 2 * -4"));
    assertEquals("Multiplication of positive integers", BigInteger.valueOf(16), Calculator.eval0("2 * 2 * 4"));
    assertEquals("Multiplication of negative integers", BigInteger.valueOf(-48), Calculator.eval0("-1 * -4 * -12"));
    assertEquals("Multiplication of positive and negative integers", BigInteger.valueOf(48), Calculator.eval0("-1 * 4 * -12"));
    assertEquals("Addition of small negatives and positives", BigInteger.valueOf(1), Calculator.eval0("-3 + 5 + -1"));
    assertEquals("Large exponent", BigInteger.valueOf(1048576), Calculator.eval0("2 ^ 20"));
    assertEquals("Exponent and multiplication", BigInteger.valueOf(2097152), Calculator.eval0("2 ^ 20 * 2"));
    assertEquals("Just 0", BigInteger.valueOf(0), Calculator.eval0("0"));
    } // testeval0
    
    @Test
    public void testFewestCoins() {
	assertArrayEquals("test one", new int[] {0, 4, 0, 0},
		   Calculator.fewestCoins(28));
	assertArrayEquals("test two", new int[] {1, 0, 0, 0},
		   Calculator.fewestCoins(2));
	assertArrayEquals("test three", new int[] {1, 1, 1, 0},
		   Calculator.fewestCoins(20));
	
    } // test fewest coins

}
