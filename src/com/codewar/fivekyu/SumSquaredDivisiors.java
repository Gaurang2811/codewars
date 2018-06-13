package com.codewar.fivekyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ga.omar
 * 
 *         <h1>Integers Recreation One</h1>
 *         <p>
 *         Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors
 *         squared are: 1, 4, 9, 36, 49, 196, 441, 1764. The sum of the squared
 *         divisors is 2500 which is 50 * 50, a square!
 *         </p>
 *         <p>
 *         Given two integers m, n (1 &lt;= m &lt;= n) we want to find all
 *         integers between m and n whose sum of squared divisors is itself a
 *         square. 42 is such a number.
 *         </p>
 *         <p>
 *         The result will be an array of arrays or of tuples (in C an array of
 *         Pair) or a string, each subarray having two elements, first the
 *         number whose squared divisors is a square and then the sum of the
 *         squared divisors.
 *         </p>
 *         <p>
 *         #Examples:
 *         </p>
 * 
 *         <pre>
 * <code>list_squared(1, 250) --&gt; [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --&gt; [[42, 2500], [246, 84100]]
</code>
 *         </pre>
 *         <p>
 *         The form of the examples may change according to the language, see
 *         <code>Example Tests:</code> for more details.
 *         </p>
 *         <p>
 *         <strong>Note</strong>
 *         </p>
 * 
 */
public class SumSquaredDivisiors {

	public static void main(String[] args) {
		listSquared(1, 250);

	}

	public static String listSquared(long m, long n) {

		List<String> squaredList = new ArrayList();

		for (long i = m; i <= n; i++) {
			long square = getSquareSum(getDivisiors(i));
			if (checkIfSquare(square)) {
				List<Long> temp = new ArrayList();
				temp.add(i);
				temp.add(square);
				squaredList.add(temp.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]")));
			}
		}
		return squaredList.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
	}

	private static boolean checkIfSquare(long squareSum) {
		return Math.sqrt(squareSum) % 1 == 0 ? true : false;
	}

	private static long getSquareSum(long[] divisiors) {
		long sumResult = 0;
		for (long l : divisiors) {
			sumResult += l * l;
		}
		return sumResult;

	}

	private static long[] getDivisiors(long num) {

		List<Long> divisiors = new ArrayList<Long>();

		long itr = (long) num / 2;
		for (long i = 1; i <= itr; i++) {
			if (num % i == 0)
				divisiors.add(i);
		}
		divisiors.add(num);
		return divisiors.stream().mapToLong(i -> i).toArray();

	}
}
