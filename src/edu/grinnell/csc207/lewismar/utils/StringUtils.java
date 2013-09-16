/*
 * @author Matt Dole
 * @author Mark Lewis
 * HW-3
 */
package edu.grinnell.csc207.lewismar.utils;

public class StringUtils {
    public static String[] splitAt(String str, char ch) {
	int countCh = 0; 
	// Count how many times ch occurs in str
	for(int i = 0; i< str.length(); i++) {
	    if(ch == str.charAt(i)) {
		countCh++;
	    } // if ch == str.charAt(i)
	} // for

	// if all characters in str are ch, this is fine, else, need one more element
	if(str.length() != countCh) {
	    countCh++;
	} // if

	String[] split = new String[countCh];
	int arrayCounter = 0;

	// All elements of split are currently null, change them to ""
	for (int i = 0; i < split.length; i++) {
	    split[i] = "" + ""; // addition so that split[i] is a string (multiple characters)
	} // for

	for (int i = 0; i < str.length(); i++) {
	    if(ch != str.charAt(i)) {
		split[arrayCounter] += str.charAt(i);
	    } //if
	    else {
		arrayCounter++;
	    } // else
	} // for
	return split;
    } // splitAt
    
    public static String[] splitCSV(String str) {
	// Count how many times comma's appear outside of quotation marks
	Boolean insideQuote = false;
	int getArrayLength = 0;
	for(int i = 0; i< str.length(); i++) {
	    if(str.charAt(i) == '"') {
		// Advance if next character is a double quote
		if(i != str.length() -1 && str.charAt(i+1) == '"') {
		    i++;
		} else if(!insideQuote) {
		    insideQuote = true;
		} else {
		    insideQuote = false;
		} // else
	    } else if(!insideQuote && str.charAt(i) == ',') {
		getArrayLength++;
	    } // if
	} // for
	
	//if all characters in str are ch, this is fine, else, need one more element
	if(str.length() != getArrayLength) {
	    getArrayLength++;
	} // if
	
	String[] split = new String[getArrayLength];
	int currentPos = 0;
	String currentString = "";
	insideQuote = false;
	// All elements of split are currently null, change them to ""
	for (int i = 0; i < split.length; i++) {
	    split[i] = "" + ""; // addition so that split[i] is a string (multiple characters)
	} // for
	
	// build the split array
	for(int i = 0; i < str.length(); i++) {
	  // handle quotes
	    if(str.charAt(i) == '"') {
		// special case: i = 0
		if(i != str.length() -1 && str.charAt(i+1) == '"') {
		    i += 2;
		    currentString += '"';
		} // if
		// switch inside quote
		if(!insideQuote) {
		    insideQuote = true;
		} else {
		    insideQuote = false;
		} // else
	    } else if(str.charAt(i) == ',') {
		// handle commas
		if (insideQuote) {
		    currentString += ',';
		} else {
		    split[currentPos] = currentString;
		    currentPos ++;
		    currentString = "";
		} // else
	    } else {
		// handle any other character
		currentString += str.charAt(i); 
	    } //else
	} // for
	//add what remains
	split[currentPos] = currentString;
	return split;
    } // splitCSV
    // Citations: We consulted http://docs.oracle.com/javase/tutorial/java/data/characters.html for use of the character \
    public static String deLeet(String str) {
	String deLeeted = "";
	for (int i = 0; i < str.length(); i++) {
	    if(str.charAt(i) == '+') {
		deLeeted += 't';
	    } // if
	    else if(str.charAt(i) == '1') {
		deLeeted += 'l';
	    } // if
	    else if(i != (str.length() -1) && str.charAt(i) == '|' && str.charAt(i + 1) == '3') {
		deLeeted += 'b';
		i++;
	    } // if
	    else if(i != (str.length() -2) && str.charAt(i) == '|' && str.charAt(i + 1) == '\\' && str.charAt(i + 2) == '|' ) {
		deLeeted += 'n';
		i += 2;
	    } // if
	    else if(str.charAt(i) == '3') {
		deLeeted += 'e';
	    } // if
	    else if(str.charAt(i) == '@') {
		deLeeted += 'a';
	    } // if
	    else if(str.charAt(i) == '0') {
		deLeeted += 'o';
	    } // if
	    else {
		deLeeted += str.charAt(i);
	    }
	} // for
	return deLeeted;
    } // deLeet

    public static String nameGame(String name) {
	String verse = name + '!'+ '\n' + name + ", " + name + " bo" ;
	String withoutCons = "";
	int count = 0;
	boolean isSplit = false;
	while (!isSplit) {
	    if(name.charAt(count) == 'a' || name.charAt(count) == 'e' || name.charAt(count) == 'i' 
		    || name.charAt(count) == 'o' || name.charAt(count) == 'u') {
		withoutCons = name.substring(count);
		isSplit = true;
	    }
	    count ++;
	} //while
	verse += " B" + withoutCons + " Bonana fanna fo F" + withoutCons + '\n';
	verse += "Fee fy mo M" + withoutCons + ", " + name + '!';
	return verse;
    } // nameGame

}
