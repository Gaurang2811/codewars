package com.codewar.encodeDecodeSquareString;

import java.util.Arrays;
import java.util.function.Function;

public class SquaredString {
	public static void main(String[] args) {
		String s = "abcd\nefgh\nijkl\nmnop";
		// System.out.println(s);
		// System.out.println(diag1Sym(s));
		System.out.println(rot90Clock(s));
		// System.out.println(rot90Clock(rot90AntiClock(s)));
		// System.out.println(selfieAndDiag1(s));
		// System.out.println(oper(SquaredString::selfieAndDiag1, s));
		// System.out.println();
		// System.out.println("NJVGhr|NMtsrz\nMObsvw|JOPotj\ntPhCtl|VbhEQl\nsoEnhi|GsCnRi\nrtQRLK|hvthLW\nzjliWg|rwliKg");
	}

	public static String diag1Sym(String s) {
		String[] arr = s.split("\n");
		String[] resArr = new String[arr.length];
		Arrays.fill(resArr, "");
		for (String string : arr) {
			for (int i = 0; i < arr.length; i++) {
				resArr[i] += string.charAt(i);
			}
		}
		return String.join("\n", resArr);
	}

	public static String rot90Clock(String s) {
		String[] arr = s.split("\n");
		String[] resArr = new String[arr.length];
		Arrays.fill(resArr, "");
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = arr.length - 1; i >= 0; i--) {
				resArr[i] += arr[j].charAt(i);
			}
		}
		return String.join("\n", resArr).toString();
	}

	public static String selfieAndDiag1(String s) {
		String rev = diag1Sym(s);
		String[] arr = s.split("\n");
		String[] resArr = rev.split("\n");
		rev = "";
		for (int i = 0; i < arr.length; i++) {
			rev += arr[i] + "|" + resArr[i] + "\n";
		}
		return rev.toString().substring(0, rev.length() - 1);
	}

	public static String rot90AntiClock(String s) {
		String[] arr = s.split("\n");
		String[] resArr = new String[arr.length];
		Arrays.fill(resArr, "");
		for (int j = 0; j < arr.length; j++) {
			int k = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				resArr[i] += arr[j].charAt(k++);
			}
		}
		return String.join("\n", resArr).toString();
	}

	public static String oper(Function<String, String> operator, String s) {
		return operator.apply(s);
	}
}
