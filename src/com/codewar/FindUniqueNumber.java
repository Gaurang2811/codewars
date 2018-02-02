package com.codewar;

/**
 * <p>
 * There is an array with some numbers. All numbers are equal except for one.
 * Try to find it!
 * </p>
 * 
 * <pre>
 * <code>
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * </code>
 * <code>
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * </code>
 * </pre>
 * <p>
 * It’s guaranteed that array contains more than 3 numbers.
 * </p>
 * <p>
 * The tests contain some very huge arrays, so think about performance.
 * </p>
 * 
 * 
 * @author ga.omar
 *
 */
public class FindUniqueNumber {
	public static void main(String[] args) {
		System.out.println(FindUniqueNumber.findUniq(new double[] { 0, 1, 0 }));
		System.out.println(FindUniqueNumber.findUniq(new double[] { 1, 1, 1, 2, 1, 1 }));
	}

	public static double findUniq(double arr[]) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[0] != arr[i]) {
				count = i;
				break;
			}
		}
		if (count > 1)
			return arr[count];
		else {
			if (arr[0] == arr[2])
				return arr[1];
			else
				return arr[0];
		}
	}
}
