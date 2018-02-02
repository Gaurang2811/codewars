package com.codewar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleParenthesisRemoval {

	String first = "(x-(y+z))"; // "x-y-z"
	String second = "x-(y-z)"; // "x-y+z"
	String third = "u-(v-w-(x+y))-z"; // "u-v+w+x+y-z"
	String fourth = "x-(-y-z)"; // "x+y+z"

	public static void main(String aa[]) {
		SimpleParenthesisRemoval simpleParenthesisRemoval = new SimpleParenthesisRemoval();

		String str = simpleParenthesisRemoval
				.solvedString(simpleParenthesisRemoval.removeFirstParanthesisIfExist(simpleParenthesisRemoval.fourth));
		System.out.println(str);

	}

	public String solvedString(String unsolved) {

		boolean swapSign = false;
		String string = "";
		for (int i = 0; i < unsolved.length(); i++) {
			char c = unsolved.charAt(i);
			if (c == '(' && unsolved.charAt(i - 1) == '-') {
				swapSign = !swapSign;
				c = ' ';
			}
			if (c == ')') {
				swapSign = !swapSign;
				c = ' ';
			}
			if (c == '-' && swapSign) {
				c = '+';
			} else if (c == '+' && swapSign) {
				c = '-';
			}
			string += c;
		}
		return string.replaceAll("\\s", "").replaceAll("\\-\\+", "+");
	}

	public String removeFirstParanthesisIfExist(String str) {
		if (str.startsWith("(")) {
			return str.substring(1, str.length() - 1);
		} else {
			return str;
		}
	}
}
