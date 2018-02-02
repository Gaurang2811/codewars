package com.codewar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <h1>Delete occurrences of an element if it occurs more than n times</h1>
 * 
 * <h2>Enough is enough!</h2>
 * <p>
 * Alice and Bob were on a holiday. Both of them took many pictures of the
 * places they've been, and now they want to show Charlie their entire
 * collection. However, Charlie doesn't like this sessions, since the motive
 * usually repeats. He isn't fond of seeing the Eiffel tower 40 times. He tells
 * them that he will only sit during the session if they show the same motive at
 * most N times. Luckily, Alice and Bob are able to encode the motive as a
 * number. Can you help them to remove numbers such that their list contains
 * each number only up to N times, without changing the order?
 * </p>
 * 
 * 
 * <h3>Task</h3>
 * <p>
 * Given a list lst and a number N, create a new list that contains each number
 * of lst at most N times without reordering. For example if N = 2, and the
 * input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since
 * this would lead to 1 and 2 being in the result 3 times, and then take 3,
 * which leads to [1,2,3,1,2,3].
 * </p>
 * <h4>Example</h4>
 * 
 * <pre>
 * EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) will return [20,37,21]
 * </pre>
 * 
 * <pre>
 * EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) will return [1, 1, 3, 3, 7, 2, 2, 2]
 * </pre>
 * 
 * @author ga.omar
 *
 */
public class EnoughIsEnough {

	public static void main(String[] args) {
		System.out.println(EnoughIsEnough.deleteNth(new int[] { 20, 37, 20, 21 }, 1));
		System.out.println(EnoughIsEnough.deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3));
		System.out.println(EnoughIsEnough.deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3));
		System.out.println(EnoughIsEnough.deleteNth(new int[] {}, 5));
		System.out.println(EnoughIsEnough.deleteNth(new int[] { 1, 1, 1, 1, 1 }, 5));
		System.out.println(EnoughIsEnough.deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3));
	}

	public static int[] deleteNth(int[] elements, int maxOcurrences) {

		Map<Integer, Integer> count = new HashMap<>();

		List<Integer> list = new ArrayList<Integer>();
		int[] fixedEl = null;
		for (int i = 0; i < elements.length; i++) {
			if (count.containsKey(elements[i]))
				count.put(elements[i], (count.get(elements[i]) + 1));
			else
				count.put(elements[i], 1);
			if (count.get(elements[i]) <= maxOcurrences)
				list.add(elements[i]);
		}
		fixedEl = new int[list.size()];
		Iterator<Integer> itr = list.iterator();
		int i = 0;
		while (itr.hasNext()) {
			fixedEl[i] = itr.next();
			i++;
		}

		for (int o : fixedEl) {
			System.out.print(o + ", ");
		}

		return fixedEl;

		// declarative method for converting List to Array
		// return list.stream().mapToInt(integer -> integer).toArray();
	}
}
