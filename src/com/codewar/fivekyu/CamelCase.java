package com.codewar.fivekyu;

import java.io.StringBufferInputStream;
import java.util.Arrays;

/**
 * 
 * <p>
 * Complete the method/function so that it converts dash/underscore delimited
 * words into camel casing. The first word within the output should be
 * capitalized only if the original word was capitalized.
 * </p>
 *
 * <p>
 * Examples:
 * </p>
 * 
 * <pre>
 * <code>// returns "theStealthWarrior"
toCamelCase("the-stealth-warrior") 

// returns "TheStealthWarrior"
toCamelCase("The_Stealth_Warrior")
</code>
 * </pre>
 * 
 * @author ga.omar
 *
 */
public class CamelCase {

	public static void main(String[] args) {
		String s1 = "the-stealth-warrior";
		String s = "The_Stealth_Warrior";
		System.out.println(toCamelCase(s));
		System.out.println(toCamelCase(s1));
	}

	static String toCamelCase(String s) {

		String[] arr = s.split("[-_]");
		String str = arr[0];

		for (int i = 1; i < arr.length; i++)
			str += Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1, arr[i].length());
		return str;
	}
}
