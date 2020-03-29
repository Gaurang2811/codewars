package com.codewar;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		System.out.println(getUniqueSubstring("axyabcde"));
	}

	public static int getUniqueSubstring(String s) {
		int startInd = 0, endInd = 0, maxXountTillNow = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int temp = 0; temp < s.toCharArray().length; temp++) {
			char curChar = s.charAt(temp);
			if (map.containsKey(curChar)) {
				endInd = temp - 1;
				maxXountTillNow = Integer.max(endInd - startInd, maxXountTillNow);
				startInd = map.get(curChar);
				map.replace(curChar, temp);
			} else {
				endInd = temp;
				map.put(curChar, temp);
				maxXountTillNow = Integer.max(endInd - startInd, maxXountTillNow);
			}
		}
		return maxXountTillNow;
	}
}
