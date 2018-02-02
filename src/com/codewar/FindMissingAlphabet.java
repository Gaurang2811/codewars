package com.codewar;

/**
 * 
 * <storng> #Find the missing letter </strong>
 * <p>
 * Write a method that takes an array of consecutive (increasing) letters as
 * input and that returns the missing letter in the array.
 * </p>
 * <p>
 * You will always get an valid array. And it will be always exactly one letter
 * be missing. The length of the array will always be at least 2.<br>
 * The array will always contain letters in only one case.
 * </p>
 * <p>
 * Example:
 * </p>
 * 
 * <pre>
 * <code>[<span class="hljs-symbol">'a</span>',<span class=
 * "hljs-symbol">'b</span>',<span class="hljs-symbol">'c</span>',<span class=
 * "hljs-symbol">'d</span>',<span class=
 * "hljs-symbol">'f</span>'] -&gt; <span class="hljs-symbol">'e</span>'
 * [<span class="hljs-symbol">'O</span>',<span class=
 * "hljs-symbol">'Q</span>',<span class="hljs-symbol">'R</span>',<span class=
 * "hljs-symbol">'S</span>'] -&gt; <span class="hljs-symbol">'P</span>'
 * </code>
 * </pre>
 * <p>
 * (Use the English alphabet with 26 letters!)
 * </p>
 * 
 * @author ga.omar
 *
 */
public class FindMissingAlphabet {

	public static void main(String[] args) {
		System.out.println(findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
		System.out.println(findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
	}

	public static char findMissingLetter(char[] array) {
		char missingAplhabet = ' ';
		for (int i = 0; i < array.length - 1; i++) {
			if ((int) array[i + 1] - (int) array[i] > 1) {
				return (char) (array[i] + 1);
			}
		}
		return missingAplhabet;
	}

}
