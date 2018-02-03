package com.codewar.fivekyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * <p>
 * My friend John and I are members of the "Fat to Fit Club (FFC)". John is
 * worried because each month a list with the weights of members is published
 * and each month he is the last on the list which means he is the heaviest.
 * </p>
 * <p>
 * I am the one who establishes the list so I told him: "Don't worry any more, I
 * will modify the order of the list". It was decided to attribute a "weight" to
 * numbers. The weight of a number will be from now on the sum of its digits.
 * </p>
 * <p>
 * For example <code>99</code> will have "weight" <code>18</code>,
 * <code>100</code> will have "weight" <code>1</code> so in the list
 * <code>100</code> will come before <code>99</code>. Given a string with the
 * weights of FFC members in normal order can you give this string ordered by
 * "weights" of these numbers?
 * </p>
 * <h1 id="example-">Example:</h1>
 * <p>
 * <code>"56 65 74 100 99 68 86 180 90"</code> ordered by numbers weights
 * becomes: <code>"100 180 90 56 65 74 68 86 99"</code>
 * </p>
 * <p>
 * When two numbers have the same "weight", let us class them as if they were
 * strings and not numbers: <code>100</code> is before <code>180</code> because
 * its "weight" (1) is less than the one of <code>180</code> (9) and
 * <code>180</code> is before <code>90</code> since, having the same "weight"
 * (9) it comes before as a <em>string</em>.
 * </p>
 * <p>
 * All numbers in the list are positive numbers and the list can be empty.
 * </p>
 * <h1 id="notes">Notes</h1>
 * <ul>
 * <li>it may happen that the input string have leading, trailing whitespaces
 * and more than a unique whitespace between two consecutive numbers</li>
 * <li>Don't modify the input</li>
 * <li>For C: The result is freed.</li>
 * </ul>
 * 
 * 
 * @author ga.omar
 *
 */
public class WeightSort {
	public static void main(String[] args) {

		System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}

	public static String orderWeight(String strng) {

		String arr[] = strng.trim().split("\\s+");
		String s = "";
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapForDup = new HashMap<Integer, Integer>();
		for (String str : arr) {
			int key = Integer.parseInt(str);
			int value = String.valueOf(key).chars().map(Character::getNumericValue).sum();
			if (!map.containsKey(key))
				map.put(key, value);
			else
				mapForDup.put(key, mapForDup.containsKey(key) ? mapForDup.get(key) + 1 : 1);
		}
		List<Entry<Integer, Integer>> l = sortByValue(map);
		for (Entry<Integer, Integer> object : l) {
			if (mapForDup.containsKey(object.getKey())) {
				for (int i = 0; i < mapForDup.get(object.getKey()); i++) {
					s += object.getKey() + " ";
				}
			}
			s += object.getKey() + " ";
		}
		return s.trim();
	}

	private static List sortByValue(Map map) {
		Set<Entry<Integer, Integer>> set = map.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() != o2.getValue())
					return (o1.getValue()).compareTo(o2.getValue());
				else
					return (String.valueOf(o1.getKey())).compareTo(String.valueOf(o2.getKey()));

			}
		});
		return list;
	}

	private static void printArray(String[] arr) {
		for (String string : arr) {
			System.out.println(string);
		}
	}

	private static void printMap(Map map) {
		for (Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); entries.hasNext();) {
			Map.Entry<Integer, Integer> entry = entries.next();
			System.out.println(entry.getKey() + "==========" + entry.getValue());
		}
	}

}
