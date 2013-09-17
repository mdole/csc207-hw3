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
     * if amount cannot be achieved using 2s, 7s, 11s, and 54s the array returned will
     * contain 4 zeros
     */
    public static int[] fewestCoins(int amount) {
	int[] coinArray = new int[4]; //Java default initializes to zero
	//Special cases: coins cannot sum to i
	if (amount == 1 || amount == 3 || amount == 5) {
	    return coinArray; 
	} // if
	/* The largest amount of twos used is amount/2, the largest amount of sevens used is
	 * amount/7 etc. Therefore, the for loops should increment from 0 (fewest possible coins)
	 * to amount/2, amount/7.
	 * Inefficiently test each combination, exiting the loop when amount is hit useing the fewest possible coins
	 */

	for(int two = 0; two <= amount/2; two++) {
	    for(int seven = 0; seven <= amount/7; seven++) {
		for(int eleven = 0; eleven <= amount/11; eleven++) {
		    for(int fiftyfour = 0; fiftyfour <= amount/54; fiftyfour++) {
			if((two * 2) + (seven * 7) + (eleven * 11) + (fiftyfour * 54)
				== amount) {
			    coinArray[0] = two;
			    coinArray[1] = seven;
			    coinArray[2] = eleven;
			    coinArray[3] = fiftyfour;
			    return coinArray;
			} // if
		    } // for
		} // for
	    } // for
	} // for
	return coinArray; // This line will never be hit, compiler complains because return statements are in
	// if/for statements
    }
}
