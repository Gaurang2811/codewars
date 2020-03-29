package com.codewar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurang
 * 
 * @see
 *      <h2>Find the Number of unique characters</h2>
 *
 */
public class Gemstone {

	public static void main(String[] args) {
		String[] str = new String[] { "aaaaabgf", "aggggfbc", "akjmkkjnkbgfc" };
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length; i++) {
			for (Character ch : str[i].toCharArray()) {
				if (map.containsKey(ch)) {
					if ((i == map.get(ch)) && (i + 1 > map.get(ch)))
						map.replace(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}
			System.out.println(i + " --- " + map);
		}
		System.out.println(map.entrySet().stream().filter(el -> el.getValue() == str.length).count());
	}

}
