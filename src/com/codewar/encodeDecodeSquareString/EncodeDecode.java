package com.codewar.encodeDecodeSquareString;

import java.util.Arrays;

public class EncodeDecode {
	public static void main(String[] args) {
		String s = "Some say the world will end in fire, Some say in ice. From what I've tasted of desire "
				+ "I hold with those who favor fire. But if it had to perish twice, I think I know enough of hate"
				+ " To say that for destruction ice Is also great And would suffice.";

		String s1 = "What do you remember? When I looked at his streaky glasses, I wanted "
				+ "to leave him. And before that? He stole those cherries for me at midnight. We were walking "
				+ "in the rain and I loved him. And before that? I saw him coming "
				+ "toward me that time at the picnic, edgy, foreign.";

		String s1sol = "fa  h ttrheI ilS\nitifakw   s'irdo\nc cotnihftivce m\neAereocaihree,we\n.n   wedroe . i \n\013dIdT , es t Sls\n\013 seoe t.eIaFola\n"
				+ "\013w s nIo   srm y\n\013oatso  Bwhtoee \n\013ulrautpuhoem nt\n\013lsuyghetold sdh\n\013doc hir  d wa e\n\013  tt niif ohyi \n\013sgihoksfawfa nw\n"
				+ "\013uroaf h vi ti o\n\013fent I iotd nfr";

		String s2 = "";
		// System.out.println(decode(code(s)));
		// System.out.println(code(s2));
		// System.out.println();
		// System.out.println();
		// System.out.println();
		System.out.println(decode(s1sol));

	}

	public static String code(String s) {
		return s.isEmpty() ? "" : rot90Clock(makesquare(s));
	}

	public static String decode(String s) {
		return s.isEmpty() ? "" : cleaning(rot90AntiClock(s));

	}

	public static String makesquare(String s) {
		double sqrtLenght = Math.sqrt(s.length());
		int length = (sqrtLenght == (int) sqrtLenght ? (int) sqrtLenght : ((int) sqrtLenght + 1));
		int toAdd = 0;
		if (length * length != s.length()) {
			toAdd = (int) (Math.pow(length, 2) - s.length());
		}
		for (int i = 0; i < toAdd; i++) {
			s += Character.toString((char) 11);
		}
		String sNew = "";
		for (int i = 0; i < length; i++)
			sNew += s.substring(length * i, length * (i + 1)) + "\n";

		return sNew;
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

	public static String cleaning(String s) {
		String[] arr = s.split("\n");
		return String.join("", arr).replaceAll(Character.toString((char) 11), "");
	}
}
