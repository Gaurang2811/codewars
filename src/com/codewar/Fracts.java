package com.codewar;

/**
 * 
 * <p>
 * Common denominators
 * </p>
 * <p>
 * You will have a list of rationals in the form
 * </p>
 * 
 * <pre>
 * <code> { {numer_1, denom_1} , ... {numer_n, denom_n} }
</code>
 * </pre>
 * <p>
 * or
 * </p>
 * 
 * <pre>
 * <code> [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
</code>
 * </pre>
 * <p>
 * or
 * </p>
 * 
 * <pre>
 * <code> [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
</code>
 * </pre>
 * <p>
 * where all numbers are positive ints.
 * </p>
 * <p>
 * You have to produce a result in the form
 * </p>
 * 
 * <pre>
 * <code> (N_1, D) ... (N_n, D)
</code>
 * </pre>
 * <p>
 * or
 * </p>
 * 
 * <pre>
 * <code> [ [N_1, D] ... [N_n, D] ]
</code>
 * </pre>
 * <p>
 * or
 * </p>
 * 
 * <pre>
 * <code> [ (N_1', D) , ... (N_n, D) ]
</code>
 * </pre>
 * <p>
 * or
 * </p>
 * 
 * <pre>
 * <code>{{N_1, D} ... {N_n, D}}
</code>
 * </pre>
 * <p>
 * depending on the language (See Example tests)
 * </p>
 * <p>
 * in which D is as small as possible and
 * </p>
 * 
 * <pre>
 * <code> N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
</code>
 * </pre>
 * <p>
 * Example:
 * </p>
 * 
 * <pre>
 * <code>convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
</code>
 * </pre>
 * 
 * <h1 id="note-for-bash">Note for Bash</h1>
 * <p>
 * input is a string, e.g <code>"2,4,2,6,2,8"</code>
 * </p>
 * <p>
 * output is then <code>"6 12 4 12 3 12"</code>
 * </p>
 * 
 * @author ga.omar
 *
 */
public class Fracts {

	public static void main(String[] args) {
		long[][] lst = new long[][] { { 1, 2 }, { 1, 3 }, { 1, 4 } };
		long[][] lst1 = new long[][] { { 69, 130 }, { 87, 1310 }, { 3, 4 } };
		System.out.println(Fracts.convertFrac(lst1));
	}

	public static String convertFrac(long[][] lst) {

		long[] num = new long[lst.length], den = new long[lst.length];

		if (lst.length < 1) {
			return "";
		}

		for (int i = 0; i < lst.length; i++) {
			num[i] = lst[i][0];
			den[i] = lst[i][1];
		}

		long denLcm = lcm(den);

		for (int i = 0; i < num.length; i++) {
			num[i] = num[i] * denLcm / den[i];
		}

		String str = "";

		for (int i = 0; i < den.length; i++) {
			str += "(" + num[i] + "," + denLcm + ")";
		}

		return str;
	}

	private static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static long gcd(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = gcd(result, input[i]);
		return result;
	}

	private static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	private static long lcm(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = lcm(result, input[i]);
		return result;
	}
}
