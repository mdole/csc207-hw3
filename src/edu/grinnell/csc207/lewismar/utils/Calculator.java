/*
 * @author Matt Dole
 * @author Mark Lewis
 * HW-3
 */

package edu.grinnell.csc207.lewismar.utils;

import java.math.BigInteger;


public class Calculator {
    /*
     * str must contain only operators and numbers, separated by spaces
     * A number must be first and last, with an operator in between each
     * calculates left to right, ignoring order of operations
     */
    public static BigInteger eval0(String str) {
	// Create array of str, each space creates a new element
	String[] strArray = StringUtils.splitAt(str, ' ');
	BigInteger total = new BigInteger(strArray[0]);

	for(int i = 1; i < strArray.length; i+=2) {
	    if (strArray[i].equals("+")) {
		total = total.add(new BigInteger (strArray[i+1]));
	    } else if (strArray[i].equals("-")) {
		total = total.subtract(new BigInteger (strArray[i+1]));
	    } else if (strArray[i].equals("/")) {
		//assume valid input - do not expect division by zero
		total = total.divide(new BigInteger (strArray[i+1]));
	    } else if (strArray[i].equals("*")) {
		total = total.multiply(new BigInteger (strArray[i+1]));
	    } else if (strArray[i].equals("^")) {
		total = total.pow(Integer.parseInt(strArray[i+1]));
	    } // if  
	} // for
	return total;
    }
    /*
     * fewest coins takes an integer and returns an array containing the least amount of coins
     * needed to produce that integer
     * The array returned has 4 elements, and is of the following form:
     * {#2s used, #7s used, #11s used, #54s used}
     * if i cannot be achieved using 2s, 7s, 11s, and 54s the array returned will
     * contain 4 zeros
     */
    public static int[] fewestCoins(int i) {
	int[] coinArray = new int[4]; //Java default initializes to zero
	//Special cases: coins cannot sum to i
	if (i == 1 || i == 3 || i == 5) {
	   return coinArray; 
	}
	
	return coinArray;
    }
}
