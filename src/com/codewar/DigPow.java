package com.codewar;

/**
 * 
 * <p>
 * Some numbers have funny properties. For example:
 * </p>
 * <blockquote>
 * <p>
 * 89 --&gt; 8¹ + 9² = 89 * 1
 * </p>
 * <p>
 * 695 --&gt; 6² + 9³ + 5⁴= 1390 = 695 * 2
 * </p>
 * <p>
 * 46288 --&gt; 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * </p>
 * </blockquote>
 * <p>
 * Given a positive integer n written as abcd... (a, b, c, d... being digits)
 * and a positive integer p we want to find a positive integer k, if it exists,
 * such as the sum of the digits of n taken to the successive powers of p is
 * equal to k * n. In other words:
 * </p>
 * <blockquote>
 * <p>
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) +
 * ...) = n * k
 * </p>
 * </blockquote>
 * <p>
 * If it is the case we will return k, if not return -1.
 * </p>
 * <p>
 * <strong>Note</strong>: n, p will always be given as strictly positive
 * integers.
 * </p>
 * 
 * @author ga.omar
 *
 */
public class DigPow {
	public static void main(String[] args) {
		System.out.println(digPow1(89, 1));
		System.out.println(digPow1(92, 1));
		System.out.println(digPow1(46288, 3));
		System.out.println(digPow1(3456789, 1));
	}

	public static long digPow(int n, int p) {
		int num = n, revNum = 0;
		double k = 1;
		long bigFunny = 0;
		String str = "";
		while (num > 0) {
			str += (num % 10);
			num = num / 10;
		}
		revNum = Integer.parseInt(str);
		while (revNum > 0) {
			bigFunny += (long) (Math.pow((revNum % 10), p++));
			revNum = revNum / 10;
		}
		k = (double) bigFunny / n;
		if (k == (int) k && k != 0.0)
			return (long) k;
		return -1;
	}

	public static long digPow1(int n, int p) {
		long bigFunny = 0;
		String strn = String.valueOf(n);
		for (int i = 0; i < strn.length(); i++) {
			bigFunny += Math.pow(Character.getNumericValue(strn.charAt(i)), p + i);
			// System.out.println("----------------" +
			// Integer.valueOf(strn.charAt(i) - '0'));
			// System.out.println("----------------" + (int) (strn.charAt(i) -
			// '0'));
			// System.out.println("----------------" +
			// Character.getNumericValue(strn.charAt(i)));
			// System.out.println(bigFunny);
		}
		double k = (double) bigFunny / n;
		if (k == (int) k && k != 0.0)
			return (long) k;
		return -1;
	}
}
