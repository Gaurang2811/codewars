package com.codewar;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 * <p>
 * Your task is to make a function that can take any non-negative integer as a
 * argument and return it with its digits in descending order. Essentially,
 * rearrange the digits to create the highest possible number.
 * </p>
 * <h3 id="examples-">Examples:</h3>
 * <p>
 * Input: <code>21445</code> Output: <code>54421</code>
 * </p>
 * <p>
 * Input: <code>145263</code> Output: <code>654321</code>
 * </p>
 * <p>
 * Input: <code>1254859723</code> Output: <code>9875543221</code>
 * </p>
 * 
 * @author ga.omar
 *
 */
public class DescendingOrder {

	public static void main(String[] args) {

		System.out.println(sortDesc1(0));
		System.out.println(sortDesc1(15));
		System.out.println(sortDesc1(21445));
		System.out.println(sortDesc1(145263));
		System.out.println(sortDesc1(123456789));
		System.out.println(sortDesc1(12859723));

	}

	public static int sortDesc(final int num) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for (char i : String.valueOf(num).toCharArray()) {
			int temp = i - 48;
			if (map.containsKey(temp))
				map.put(temp, map.get(temp) + 1);
			else
				map.put(temp, 1);
		}
		String revstr = "";
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int timesLoop = entry.getValue();
			for (int i = 0; i < timesLoop; i++) {
				revstr += entry.getKey();
			}
		}

		return Integer.parseInt(revstr);
	}

	public static int sortDesc1(final int num) {
		return Integer.parseInt(String.valueOf(num).chars().mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
				.sorted(Collections.reverseOrder()).collect(Collectors.joining()));
	}
}
