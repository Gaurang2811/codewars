package com.codewar;

public class CheckSquare {

	public static boolean isSquare(int n) {
		int sqrRoot = (int) Math.sqrt(n);
		// if (sqrRoot * sqrRoot == n) {
		// return true;
		// } else {
		// return false;
		// }
		return sqrRoot * sqrRoot == n; // can be done in one line :)
	}

	private static boolean isSquareSmart(int n) {
		return Math.sqrt(n) % 1 == 0;
	}

	public static void main(String[] args) {
		System.out.println(CheckSquare.isSquare(-1)); // => false
		System.out.println(CheckSquare.isSquare(3));// => false
		System.out.println(CheckSquare.isSquare(4));// => true
		System.out.println(CheckSquare.isSquare(25)); // => true
		System.out.println(CheckSquare.isSquare(26)); // => false
	}

}
