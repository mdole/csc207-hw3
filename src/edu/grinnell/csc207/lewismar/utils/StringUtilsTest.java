/*
 * @author Matt Dole
 * @author Mark Lewis
 * HW-3
 */
package edu.grinnell.csc207.lewismar.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testSplitAt() {
	assertArrayEquals("Test one",new String[] { "a", "b", "c" },
		StringUtils.splitAt("a:b:c", ':'));
	assertArrayEquals("test two", new String[] { "a", "b", "c" },
		StringUtils.splitAt("a b c", ' '));
	assertArrayEquals("test three", new String[] { "a:b:c" },
		StringUtils.splitAt("a:b:c", ' '));
	assertArrayEquals("one field", new String[] { "a" },
		StringUtils.splitAt("a", ':'));
	assertArrayEquals("leading empty field", new String[] { "", "a" },
		StringUtils.splitAt(":a", ':'));
	assertArrayEquals("all empty fields", new String[] { "", "", "" },
		StringUtils.splitAt(":::", ':'));
	assertArrayEquals("trailing empty field", new String[] { "a", "" },
		StringUtils.splitAt("a:", ':'));   
	assertArrayEquals("not colon", new String[] { "a", "b" },
		StringUtils.splitAt("a.b", '.'));   
    }

    @Test
    public void testDeLeet () {
	assertEquals("e", StringUtils.deLeet("3"));
	assertEquals("leet", StringUtils.deLeet("133+"));
	assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
    }

    @Test
    public void testNameGame() {
	assertEquals("Lincoln", "Lincoln!\nLincoln, Lincoln bo Bincoln Bonana fanna fo Fincoln\nFee fy mo Mincoln, Lincoln!",
		StringUtils.nameGame("Lincoln"));
	assertEquals("Shirley", "Shirley!\nShirley, Shirley bo Birley Bonana fanna fo Firley\nFee fy mo Mirley, Shirley!",
		StringUtils.nameGame("Shirley"));
    }
}
