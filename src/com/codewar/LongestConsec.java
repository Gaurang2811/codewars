package com.codewar;

/**
 * <p>
 * You are given an array <code><strong>strarr</strong></code> of strings and an
 * integer <code>k</code>. Your task is to return the <strong>first</strong>
 * longest string consisting of k <strong>consecutive</strong> strings taken in
 * the array.
 * </p>
 * <p>
 * #Example: longest_consec(["zone", "abigail", "theta", "form", "libe", "zas",
 * "theta", "abigail"], 2) --&gt; "abigailtheta"
 * </p>
 * <p>
 * n being the length of the string array, if <code>n = 0</code> or
 * <code>k &gt; n</code> or <code>k &lt;= 0</code> return "".
 * </p>
 * </div>
 * 
 * @author ga.omar
 *
 */
public class LongestConsec {

	public static void main(String[] args) {
		System.out.println(LongestConsec.longestConsec(
				new String[] { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" }, 2));
		System.out.println(LongestConsec.longestConsec(
				new String[] { "ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh" },
				1));
		System.out.println(LongestConsec.longestConsec(new String[] {}, 3));
		System.out.println(LongestConsec.longestConsec(new String[] { "itvayloxrp",
				"wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck" }, 2));
		System.out.println(LongestConsec
				.longestConsec(new String[] { "wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu" }, 2));
		System.out.println(
				LongestConsec.longestConsec(new String[] { "zone", "abigail", "theta", "form", "libe", "zas" }, -2));
		System.out.println(
				LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 3));
		System.out.println(
				LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 15));
		System.out.println(
				LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 0));
	}

	public static String longestConsec(String[] strarr, int k) {
		if (strarr.length == 0 || k > strarr.length || k <= 0)
			return "";
		String str = "";
		int startIndex = 0, count = 0;
		for (int i = 0; i <= strarr.length - k; i++) {
			int tempCount = 0;
			for (int j = 0; j < k; j++) {
				tempCount += strarr[i + j].length();
			}
			if (tempCount > count) {
				count = tempCount;
				startIndex = i;
			}
		}
		for (int i = startIndex; i < startIndex + k; i++)
			str += strarr[i];
		return str;
	}

}
