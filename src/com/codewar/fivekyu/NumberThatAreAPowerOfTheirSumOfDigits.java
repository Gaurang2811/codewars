package ques;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <div class="description is-full-height has-auto-scrolling mbm pam"><div class
 * ="markdown" id="description">
 * <p>
 * The number 81 has a special property, a certain power of the sum of its
 * digits is equal to 81 (nine squared). Eighty one (81), is the first number in
 * having this property (not considering numbers of one digit). The next one, is
 * 512. Let's see both cases with the details
 * </p>
 * <p>
 * 8 + 1 = 9 and 9<sup>2</sup> = 81
 * </p>
 * <p>
 * 512 = 5 + 1 + 2 = 8 and 8<sup>3</sup> = 512
 * </p>
 * <p>
 * We need to make a function, <code>power_sumDigTerm()</code>, that receives a
 * number <code>n</code> and may output the <code>n-th term</code> of this
 * sequence of numbers. The cases we presented above means that
 * </p>
 * <p>
 * power_sumDigTerm(1) == 81
 * </p>
 * <p>
 * power_sumDigTerm(2) == 512
 * </p>
 * <p>
 * Happy coding!
 * </p>
 * </div>
 * 
 */
public class NumberThatAreAPowerOfTheirSumOfDigits {

	public static long powerSumDigTerm(int n) {
		ArrayList<Long> res = new ArrayList<Long>();
		for (long j = 2; j < 100; j++) {
			for (long i = 4; i < 50; i++) {
				long num = (long) Math.pow(i, j);
				long numSum = getSum(num);
				if (i == numSum) {
					System.out.print(num + " : ");
					res.add(num);
				}
			}
		}
		Collections.sort(res);
		return res.get(n - 1);
	}

	static long getSum(long num) {
		long sum = 0;
		while (num != 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(powerSumDigTerm(3));
	}
}
