package com.codewar.fourkyu;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <blockquote>
 * <p>
 * "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's
 * an interesting number coming up, he notices and then promptly forgets. Who
 * <em>doesn't</em> like catching those one-off interesting mileage numbers?
 * </p>
 * </blockquote>
 * <p>
 * Let's make it so Bob <strong>never</strong> misses another interesting
 * number. We've hacked into his car's computer, and we have a box hooked up
 * that reads mileage numbers. We've got a box glued to his dash that lights up
 * yellow or green depending on whether it receives a 1 or a 2 (respectively).
 * </p>
 * <p>
 * It's up to you, intrepid warrior, to glue the parts together. Write the
 * function that parses the mileage number input, and returns a 2 if the number
 * is "interesting" (see below), a 1 if an interesting number occurs within the
 * next two miles, or a 0 if the number is not interesting.
 * </p>
 * <p>
 * <strong>Note:</strong> In Haskell, we use No Almost and Yes instead of 0, 1
 * and 2
 * </p>
 * <h2>"Interesting" Numbers</h2>
 * <p>
 * Interesting numbers are 3-or-more digit numbers that meet one or more of the
 * following criteria:
 * </p>
 * <ul>
 * <li>Any digit followed by all zeros: 100, 90000</li>
 * <li>Every digit is the same number: 1111</li>
 * <li>The digits are sequential, incementing<sup>†</sup>: 1234</li>
 * <li>The digits are sequential, decrementing<sup>‡</sup>: 4321</li>
 * <li>The digits are a palindrome: 1221 or 73837</li>
 * <li>The digits match one of the values in the awesomePhrases array</li>
 * </ul>
 * <blockquote>
 * <p>
 * <sup>†</sup> For incrementing sequences, 0 should come after 9, and not
 * before 1, as in 7890.<br>
 * <sup>‡</sup> For decrementing sequences, 0 should come after 1, and not
 * before9, as in 3210.
 * </p>
 * </blockquote>
 * <p>
 * So, you should expect these inputs and outputs:
 * </p>
 * 
 * <pre>
<span>// "boring" numbers</span>
isInteresting(<span>3</span>, [<span>-number">1337</span>, <span>-number">256</span>]); <span>// 0</span>
isInteresting(<span>3236</span>, [<span>-number">1337</span>, <span>256</span>]); <span>// 0</span>

<span>// progress as we near an "interesting" number</span>
isInteresting(<span>11207</span>, []); <span>// 0</span>
isInteresting(<span>11208</span>, []); <span>// 0</span>
isInteresting(<span>11209</span>, []); <span>// 1</span>
isInteresting(<span>11210</span>, []); <span>// 1</span>
isInteresting(<span>11211</span>, []); <span>// 2</span>

<span>// nearing a provided "awesome phrase"</span>
isInteresting(<span>1335</span>, [<span>-number">1337</span>, <span>256</span>]); <span>// 1</span>
isInteresting(<span>1336</span>, [<span>-number">1337</span>, <span>256</span>]); <span>// 1</span>
isInteresting(<span>1337</span>, [<span>-number">1337</span>, <span>256</span>]); <span>// 2</span>
 * </pre>
 * 
 * <h2>Error Checking</h2>
 * <ul>
 * <li>A number is only interesting if it is greater than <code>99</code>!</li>
 * <li>Input will <em>always</em> be an integer greater than <code>0</code>, and
 * less than <code>1,000,000,000</code>.</li>
 * <li>The <code>awesomePhrases</code> array will always be provided, and will
 * always be an array, but may be empty. (Not <em>everyone</em> thinks numbers
 * spell funny words...)</li>
 * <li>You should only ever output <code>0</code>, <code>1</code>, or
 * <code>2</code>.</li>
 * </ul>
 * 
 * 
 * @author ga.omar
 *
 */
public class CarMileage {
	public static void main(String[] args) {

		System.out.println(isInteresting(123, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(12321, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(1357531, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(12, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(0000, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(1020000, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(6543210, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(1111111, new int[] { 12, 123, 123, 123 }));
		System.out.println(isInteresting(120000000, new int[] { 12, 123, 123, 120000000 }));
		System.out.println(isInteresting(11209, new int[] {}));
		System.out.println(isInteresting(98, new int[] {}));

	}

	public static int isInteresting(int number, int[] awesomePhrases) {
		if (number < 98)
			return 0;
		if (number > 99) {
			if (checkForZeroAndSame(number) || checkForAwesomePhrase(number, awesomePhrases)
					|| checkForPalindrome(number) || checkForIncrement(number) || checkForDecrement(number))
				return 2;
		}

		number++;
		if (number > 99) {
			if (checkForZeroAndSame(number) || checkForAwesomePhrase(number, awesomePhrases)
					|| checkForPalindrome(number) || checkForIncrement(number) || checkForDecrement(number))
				return 1;
		}

		number++;
		if (number > 99) {
			if (checkForZeroAndSame(number) || checkForAwesomePhrase(number, awesomePhrases)
					|| checkForPalindrome(number) || checkForIncrement(number) || checkForDecrement(number))
				return 1;
		}
		return 0;
	}

	public static boolean checkForZeroAndSame(int num) {
		AtomicReference<String> result = new AtomicReference<>();
		result.set("true");
		int first = Integer.parseInt(String.valueOf(num).substring(0, 1));

		Integer sum = String.valueOf(num).chars().mapToObj(i -> {
			if ((i - 48) != first && result.get().equalsIgnoreCase("true"))
				result.set("false");
			return i - 48;
		}).mapToInt(Integer::intValue).sum();

		if (result.get().equalsIgnoreCase("true"))
			return true;
		else if (sum == first)
			return true;
		else
			return false;
	}

	private static boolean checkForAwesomePhrase(int num, int[] awesomePhrase) {
		for (int i : awesomePhrase) {
			if (num == i)
				return true;
		}
		return false;
	}

	private static boolean checkForPalindrome(int number) {
		int realNum = number;
		int reversedNum = 0;
		while (number != 0) {
			reversedNum = reversedNum * 10 + number % 10;
			number = number / 10;
		}
		if (realNum == reversedNum)
			return true;
		return false;
	}

	private static boolean checkForIncrement(int number) {
		AtomicReference<String> result = new AtomicReference<>();
		result.set("true");
		AtomicReference<Integer> atomic = new AtomicReference<>();
		Integer first = Integer.parseInt(String.valueOf(number).substring(0, 1));
		String num = String.valueOf(number).substring(1, String.valueOf(number).length());
		atomic.set(first);
		num.chars().mapToObj(i -> {
			if (atomic.get() == 0 && (i - 48) == 1 && result.get().equalsIgnoreCase("true"))
				result.set("false");
			if (((atomic.get() + 1) == (i - 48) || (atomic.get() == 9 && (i - 48) == 0))
					&& result.get().equalsIgnoreCase("true"))
				atomic.set(i - 48);
			else
				result.set("false");
			return i - 48;
		}).mapToInt(Integer::intValue).sum();

		if (result.get().equalsIgnoreCase("true"))
			return true;
		else
			return false;
	}

	private static boolean checkForDecrement(int number) {
		AtomicReference<String> result = new AtomicReference<>();
		result.set("true");
		AtomicReference<Integer> atomic = new AtomicReference<>();
		Integer first = Integer.parseInt(String.valueOf(number).substring(0, 1));
		String num = String.valueOf(number).substring(1, String.valueOf(number).length());
		atomic.set(first);
		num.chars().mapToObj(i -> {
			if ((atomic.get() - 1) == (i - 48) && result.get().equalsIgnoreCase("true"))
				atomic.set(i - 48);
			else
				result.set("false");
			return i - 48;
		}).mapToInt(Integer::intValue).sum();

		if (result.get().equalsIgnoreCase("true"))
			return true;
		else
			return false;
	}
}
