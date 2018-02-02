package com.codewar;

/**
 * 
 * <p>
 * This time no story, no theory. The examples below show you how to write
 * function <code>accum</code>:
 * </p>
 * <p>
 * <strong>Examples:</strong>
 * </p>
 * 
 * <pre>
 * Accumul.accum("abcd")<span>// "A-Bb-Ccc-Dddd"</span>
 * </pre>
 * 
 * <pre>
 * Accumul.accum("RqaEzty")<span>// "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"</span>
 * </pre>
 * 
 * <pre>
 * Accumul.accum("cwAt")<span>// "C-Ww-Aaa-Tttt"</span>
 * </pre>
 * 
 * @author ga.omar
 *
 */
public class Accumul {

	public static void main(String[] args) {
		System.out.println(accum("abcd"));
		System.out.println(accumSimple("RqaEzty"));
	}

	static String string = null;
	static int count = 0;

	// using Lambda
	public static String accum(String s) {
		count = 1;
		string = "";
		s.chars().forEach(str -> {
			createString((char) str, count);
			count++;
		});
		return string;
	}

	public static void createString(char c, int count) {
		if (count > 1)
			string += "-";
		for (int i = 0; i < count; i++) {
			string += i == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
		}
	}

	// second basic method
	public static String accumSimple(String s) {
		int i = 0;
		String str = "";
		for (char c : s.toCharArray()) {
			if (i > 0)
				str += "-";
			str += Character.toUpperCase(c);
			i++;
			for (int j = 1; j < i; j++)
				str += Character.toLowerCase(c);
		}
		return str;
	}
}
