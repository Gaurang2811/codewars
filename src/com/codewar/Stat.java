package com.codewar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * <h1>Statistics for an Athletic Association</h1
 * <p>
 * You are the "computer expert" of a local Athletic Association (C.A.A.). Many
 * teams of runners come to compete. Each time you get a string of all race
 * results of every team who has run. For example here is a string showing the
 * individual results of a team of 5:
 * </p>
 * <p>
 * <code>"01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"</code>
 * </p>
 * <p>
 * Each part of the string is of the form: <code>h|m|s</code> where h, m, s are
 * positive or null integer (represented as strings) with one or two digits.
 * There are no traps in this format.
 * </p>
 * <p>
 * To compare the results of the teams you are asked for giving three
 * statistics; <strong>range, average and median</strong>.
 * </p>
 * <p>
 * <code>Range</code> : difference between the lowest and highest values. In {4,
 * 6, 9, 3, 7} the lowest value is 3, and the highest is 9, so the range is 9 −
 * 3 = 6.
 * </p>
 * <p>
 * <code>Mean or Average</code> : To calculate mean, add together all of the
 * numbers in a set and then divide the sum by the total count of numbers.
 * </p>
 * <p>
 * <code>Median</code> : In statistics, the median is the number separating the
 * higher half of a data sample from the lower half. The median of a finite list
 * of numbers can be found by arranging all the observations from lowest value
 * to highest value and picking the middle one (e.g., the median of {3, 3, 5, 9,
 * 11} is 5) when there is an odd number of observations. If there is an even
 * number of observations, then there is no single middle value; the median is
 * then defined to be the mean of the two middle values (the median of {3, 5, 6,
 * 9} is (5 + 6) / 2 = 5.5).
 * </p>
 * <p>
 * Your task is to return a string giving these 3 values. For the example given
 * above, the string result will be
 * </p>
 * <p>
 * <code>"Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"</code>
 * </p>
 * <p>
 * of the form:
 * </p>
 * <p>
 * <code>"Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"</code>
 * </p>
 * <p>
 * where hh, mm, ss are integers (represented by strings) with <em>each 2
 * digits</em>.
 * </p>
 * <p>
 * <em>Remarks</em>:
 * </p>
 * <ol>
 * <li>
 * <p>
 * if a result in seconds is ab.xy... it will be given
 * <strong>truncated</strong> as ab.
 * </p>
 * </li>
 * <li>
 * <p>
 * if the given string is "" you will return ""
 * </p>
 * </li>
 * </ol>
 * 
 * @author ga.omar
 *
 */
public class Stat {
	public static void main(String[] args) {
		System.out.println(Stat.stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
		System.out.println(Stat.stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"));
		System.out.println(Stat.stat("01|03|25"));
	}

	public static String stat(String strg) {
		String[] allRecords = strg.split(",");

		// can also be done using arrays, List because of previous
		// implementation
		List<Long> longTime = new ArrayList<>();
		long totalSeconds = 0;

		String Range = null, Average = null, Median = null;
		for (String time : allRecords) {
			long seconds = 0;
			String[] tempTime = time.trim().split("\\|");
			seconds = returnSeconds(tempTime);
			longTime.add(seconds);
			totalSeconds += seconds;
		}
		longTime.sort(Comparator.naturalOrder());
		Range = returnTimeStr(longTime.get(longTime.size() - 1) - longTime.get(0));
		Average = returnTimeStr(totalSeconds / longTime.size());
		Median = longTime.size() % 2 != 0 ? returnTimeStr(longTime.get(longTime.size() / 2))
				: returnTimeStr((longTime.get(longTime.size() / 2)) - (longTime.get((longTime.size() / 2) - 1)));

		return ("Range: " + Range + " Average: " + Average + " Median: " + Median);
	}

	public static long returnSeconds(String[] tempTimeStr) {
		return (Integer.valueOf(tempTimeStr[0]) * 60 * 60) + (Integer.valueOf(tempTimeStr[1]) * 60)
				+ (Integer.valueOf(tempTimeStr[2]));
	}

	public static String returnTimeStr(long seconds) {
		return String.format("%02d", seconds / 60 / 60) + "|" + String.format("%02d", (seconds / 60) % 60) + "|"
				+ String.format("%02d", seconds % 60);
	}
}
