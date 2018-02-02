package com.codewar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>
 * Given an array, find the int that appears an odd number of times.
 * </p>
 * 
 * <p>
 * There will always be only one integer that appears an odd number of times.
 * </p>
 * 
 * @author ga.omar
 *
 */
public class FindOdds {
	public static void main(String[] args) {
		System.out.println(FindOdds.findIt1(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
		System.out.println(FindOdds.findIt1(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
		// System.out.println(FindOdds.findIt(new int[] { 20, 1, 1, 2, 2, 3, 3,
		// 5, 5, 4, 20, 4, 5 }));
		// System.out.println(FindOdds.findIt(new int[] { 10 }));
		// System.out.println(FindOdds.findIt(new int[] { 1, 1, 1, 1, 1, 1, 10,
		// 1, 1, 1, 1 }));
	}

	public static int findIt(int[] A) {
		Map<Integer, Integer> intMap = new HashMap<>();
		for (int i : A) {
			if (intMap.containsKey(i)) {
				intMap.replace(i, (intMap.get(i) + 1));
			} else {
				intMap.put(i, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
			if (entry.getValue() % 2 != 0)
				return entry.getKey();
		}
		return 0;
	}

	public static int findIt1(int[] A) {
		int xor = 0;
		for (int i = 0; i < A.length; i++) {
			xor = xor ^ A[i];
			System.out.println("## " + xor);
		}
		return xor;
	}

}
