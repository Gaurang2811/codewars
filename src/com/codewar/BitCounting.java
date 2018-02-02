package com.codewar;

public class BitCounting {

	public static void main(String[] args) {
		BitCounting.countBitLam(1234);
		BitCounting.countBits(4);
		BitCounting.countBits(7);
		BitCounting.countBits(9);
		BitCounting.countBits(10);

	}

	private static int countBits(int i) {
		// java provides method for this
		// System.out.println(Integer.toBinaryString(i));

		int num = i;
		String str = "";
		while (num > 0) {
			int y = num % 2;
			str = y + str;
			num = num / 2;
		}
		int count = 0;
		for (char c : str.toCharArray()) {
			if (c == '1') {
				count++;
			}
		}
		return count;
	}

	private static int countBitLam(int i) {
		return ((int) Integer.toBinaryString(i).chars().filter(data -> data == '1').count());
	}

}