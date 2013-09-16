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
	//ADD MORE TESTING
	assertEquals("test one", BigInteger.valueOf(0), Calculator.eval0("0"));
	assertEquals("test Two", BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
	assertEquals("test three", BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
	assertEquals("test four", BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    }

}
