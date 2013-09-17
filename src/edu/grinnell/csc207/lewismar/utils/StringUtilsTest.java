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
	assertArrayEquals("Colon separator",new String[] { "a", "b", "c" },
		StringUtils.splitAt("a:b:c", ':'));
	assertArrayEquals("Space separator", new String[] { "a", "b", "c" },
		StringUtils.splitAt("a b c", ' '));
	assertArrayEquals("Period separator", new String[] { "a", "b" },
		StringUtils.splitAt("a.b", '.'));  
	assertArrayEquals("Separator is not in string", new String[] { "a:b:c" },
		StringUtils.splitAt("a:b:c", ' '));
	assertArrayEquals("One field", new String[] { "a" },
		StringUtils.splitAt("a", ':'));
	assertArrayEquals("Leading empty field", new String[] { "", "a" },
		StringUtils.splitAt(":a", ':'));
	assertArrayEquals("All empty fields", new String[] { "", "", "" },
		StringUtils.splitAt(":::", ':'));
	assertArrayEquals("Trailing empty field", new String[] { "a", "" },
		StringUtils.splitAt("a:", ':'));    
    }

    @Test
    public void testSplitCSV() {
	assertArrayEquals("No double quotes", new String[] { "a", "b", "c" },
		StringUtils.splitCSV("a,b,c"));
	assertArrayEquals("Comma within quotes", new String[] { "a,b", "c" },
		StringUtils.splitCSV("\"a,b\",c"));
	assertArrayEquals("Comma, \\, and \" within quotes", new String[] { "a", "b,b\"", "c" },
		StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	assertArrayEquals("using a \\", new String[] { "a", "\\b", "c" },
		StringUtils.splitCSV("a,\\b,c"));
	assertArrayEquals("No double quotes", new String[] { "a", "b\"", "c"},
		StringUtils.splitCSV("a,b,c"));
    }

    @Test
    public void testDeLeet () {
	assertEquals("e", StringUtils.deLeet("3"));
	assertEquals("leet", StringUtils.deLeet("133+"));
	assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
	assertEquals("nananana bat", StringUtils.deLeet("|\\|@|\\|@|\\|@|\\|@ |3@+"));
	assertEquals("loot", StringUtils.deLeet("100+"));
    }


    @Test
    public void testNameGame() {
	assertEquals("Lincoln", "Lincoln!\nLincoln, Lincoln bo Bincoln Bonana fanna fo Fincoln\nFee fy mo Mincoln, Lincoln!",
		StringUtils.nameGame("Lincoln"));
	assertEquals("Shirley", "Shirley!\nShirley, Shirley bo Birley Bonana fanna fo Firley\nFee fy mo Mirley, Shirley!",
		StringUtils.nameGame("Shirley"));
    }
}
