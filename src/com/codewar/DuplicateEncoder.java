package com.codewar;

import java.util.stream.Collectors;

/**
 * <p>
 * The goal of this exercise is to convert a string to a new string where each
 * character in the new string is '(' if that character appears only once in the
 * original string, or ')' if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a
 * duplicate.
 * </p>
 * <p>
 * Examples:
 * </p>
 * <p>
 * "din" =&gt; "((("
 * </p>
 * <p>
 * "recede" =&gt; "()()()"
 * </p>
 * <p>
 * "Success" =&gt; ")())())"
 * </p>
 * <p>
 * "(( @" =&gt; "))(("
 * </p>
 * 
 * @author ga.omar
 *
 */
public class DuplicateEncoder {

	public static void main(String[] args) {
		System.out.println(encode("   ()(   "));
		System.out.println(encode1("regede"));
		System.out.println(encode("Prespecialized"));
		System.out.println(encode("R>+*U><"));
		System.out.println(encode("l&"));
	}

	static String encode(String word) {
		// this is a work around we can addd a char that is not already present
		// in the pwovided word but it will fail if thw word contains all the
		// characters
		word = "**" + word.toLowerCase() + "**";
		String str = "";
		for (int i = 2; i < word.length() - 2; i++) {
			str += (((int) 'a' <= (int) word.charAt(i) && (int) word.charAt(i) <= (int) 'z')
					|| ((int) '0' <= (int) word.charAt(i) && (int) word.charAt(i) <= (int) '9'))
							? (word.split(word.charAt(i) + "").length > 2) ? ")" : "("
							: (word.split("\\" + word.charAt(i) + "").length > 2) ? ")" : "(";
		}
		return str;
	}

	// best way
	static String encode1(String word) {
		word = word.toLowerCase();
		String result = "";
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
		}
		return result;
	}

	// same with declarative approach
	static String encode2(String word) {
		return word.toLowerCase().chars().mapToObj(i -> String.valueOf((char) i))
				.map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
				.collect(Collectors.joining());
	}

}
