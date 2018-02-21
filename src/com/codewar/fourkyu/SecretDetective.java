package com.codewar.fourkyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * <p>
 * There is a secret string which is unknown to you. Given a collection of
 * random triplets from the string, recover the original string.
 * </p>
 * <p>
 * A triplet here is defined as a sequence of three letters such that each
 * letter occurs somewhere before the next in the given string. "whi" is a
 * triplet for the string "whatisup".
 * </p>
 * <p>
 * As a simplification, you may assume that no letter occurs more than once in
 * the secret string.
 * </p>
 * <p>
 * You can assume nothing about the triplets given to you other than that they
 * are valid triplets and that they contain sufficient information to deduce the
 * original string. In particular, this means that the secret string will never
 * contain letters that do not occur in one of the triplets given to you.
 * </p>
 * 
 * @author ga.omar
 *
 */
public class SecretDetective {

	public static void main(String[] args) {
		char[][] triplets = { { 't', 's', 'f' }, { 'a', 's', 'u' }, { 'm', 'a', 'f' }, { 'a', 'i', 'n' },
				{ 's', 'u', 'n' }, { 'm', 'f', 'u' }, { 'a', 't', 'h' }, { 't', 'h', 'i' }, { 'h', 'i', 'f' },
				{ 'm', 'h', 'f' }, { 'a', 'u', 'n' }, { 'm', 'a', 't' }, { 'f', 'u', 'n' }, { 'h', 's', 'n' },
				{ 'a', 'i', 's' }, { 'm', 's', 'n' }, { 'm', 's', 'u' } };
		// { { 't', 'u', 'p' }, { 'w', 'h', 'i' }, { 't', 's', 'u' }, { 'a',
		// 't', 's' },
		// { 'h', 'a', 'p' }, { 't', 'i', 's' }, { 'w', 'h', 's' } };

		SecretDetective s = new SecretDetective();
		System.out.println(s.recoverSecret(triplets));
	}

	public String recoverSecret(char[][] triplets) {

		List<char[]> notMached = new ArrayList<>();

		List<Character> string = new ArrayList<>();
		string.add(triplets[0][0]);
		string.add(triplets[0][1]);
		string.add(triplets[0][2]);

		for (char[] row : triplets) {
			if (string.contains(row[0])) {
				int index0 = string.indexOf(row[0]);
				if (string.contains(row[1])) {
					int index1 = string.indexOf(row[1]);
					if (index1 < index0) {
						string.remove(index1);
						string.add(string.indexOf(row[0]) + 1, row[1]);
					}
					if (string.contains(row[2])) {
						int index2 = string.indexOf(row[2]);
						if (index2 < index1) {
							string.remove(index2);
							string.add(string.indexOf(row[1]) + 1, row[2]);
						}
					} else {
						string.add(string.indexOf(row[1]) + 1, row[2]);
					}
				} else {
					string.add(string.indexOf(row[0]) + 1, row[1]);
				}
			} else if (string.contains(row[1])) {
				string.add((string.indexOf(row[1]) - 1) < 0 ? 0 : string.indexOf(row[1]) - 1, row[0]);
				if (string.contains(row[2])) {
				} else {
					string.add(string.indexOf(row[1]) + 1, row[2]);
				}
			} else if (string.contains(row[2])) {
				string.add((string.indexOf(row[2]) - 1) < 0 ? 0 : string.indexOf(row[2]) - 1, row[1]);
			} else {
				notMached.add(row);
			}
		}

		return string.stream().map(i -> String.valueOf(Character.toChars(i))).collect(Collectors.joining());

	}

}
