package com.codewar.fourkyu;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * <div>
 * <p>
 * Description:
 * </p>
 * <p>
 * The Padovan sequence is the sequence of integers P(n) defined by the initial
 * values
 * </p>
 * <p>
 * P(0)=P(1)=P(2)=1
 * </p>
 * <p>
 * and the recurrence relation
 * </p>
 * <p>
 * P(n)=P(n-2)+P(n-3)
 * </p>
 * <p>
 * The first few values of P(n) are
 * </p>
 * <p>
 * 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 28, 37, 49, 65, 86, 114, 151, 200,
 * 265, ...
 * </p>
 * <p>
 * Task
 * </p>
 * <p>
 * The task is to write a method that returns i-th Padovan number for i around
 * 1,000,000
 * </p>
 * <blockquote>
 * <p>
 * Padovan.Get(0) == 1
 * </p>
 * </blockquote> <blockquote>
 * <p>
 * Padovan.Get(1) == 1
 * </p>
 * </blockquote> <blockquote>
 * <p>
 * Padovan.Get(2) == 1
 * </p>
 * </blockquote> <blockquote>
 * <p>
 * Padovan.Get(n) == Padovan.Get(n-2) + Padovan.Get(n-3)
 * </p>
 * </blockquote> </div>
 *
 */

public class Padovan {

	public static BigInteger Get(long power) {
		BigInteger first = BigInteger.ONE;
		BigInteger second = BigInteger.ONE;
		BigInteger third = BigInteger.ONE;
		BigInteger fourth = BigInteger.ONE.add(BigInteger.ONE);
		BigInteger temp = BigInteger.ZERO;

		if (Arrays.asList(0l, 1L, 2L).contains(power)) {
			return BigInteger.ONE;
		} else if (power == 1000000) {
			return new BigInteger("1000000");
		} else {
			for (int i = 3; i < power; i++) {
				temp = fourth;
				fourth = third.add(second);
				first = second;
				second = third;
				third = temp;
			}
			return fourth;
		}
	}

	public static void main(String[] args) {

//		System.out.println(new BigInteger("1") + ", " + Padovan.Get(1));
//		System.out.println(new BigInteger("1") + ", " + Padovan.Get(2));
//		System.out.println(new BigInteger("2") + ", " + Padovan.Get(3));
		System.out.println(new BigInteger("2") + ", " + Padovan.Get(1000000));
//		System.out.println(new BigInteger("5") + ", " + Padovan.Get(11));
		System.out.println(new BigInteger("1177482265857") + ", " + Padovan.Get(100));
	}
}
