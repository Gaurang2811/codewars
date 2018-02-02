package com.codewar;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Ques- Given an array of integers your solution should find the smallest
 * integer.
 * 
 * For example:
 * 
 * Given [34, 15, 88, 2] your solution will return 2 Given [34, -345, -1, 100]
 * your solution will return -345 You can assume, for the purpose of this kata,
 * that the supplied array will not be empty.
 * 
 * @author ga.omar
 *
 */
public class SmallestIntegerFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findSmallestInt(int[] args) {
		int smallest = args[0];
		for (int i = 1; i < args.length; i++) {
			if (smallest > args[i]) {
				smallest = args[i];
			}
		}
		return smallest;
	}

	// smart
	public static int findSmallestInt1(int[] args) {
		Arrays.sort(args);
		return args[0];
	}

	// smart
	public static int findSmallestInt2(int[] args) {
		return IntStream.of(args).min().getAsInt();
	}

}
