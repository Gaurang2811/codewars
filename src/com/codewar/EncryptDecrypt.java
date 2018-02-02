package com.codewar;

/**
 * <h4>For building the encrypted string: Take every 2nd char from the string,
 * then the other chars, that are not every 2nd char, and concat them as new
 * String. Do this n times!</h4>
 * 
 * <h5>Examples:</h5>
 * <ol>
 * <li>"This is a test!", 1 -> "hsi etTi sats!"</li>
 * <li>"This is a test!", 2 -> "hsi etTi sats!" -> "s eT ashi tist!"</li>
 * </ol>
 * <h6>Write two methods:</h6>
 * 
 * <p>
 * String encrypt(final String text, final int n)
 * </p>
 * <p>
 * String decrypt(final String encryptedText, final int n)
 * </p>
 * <p>
 * For both methods: If the input-string is null or empty return exactly this
 * value!
 * </p>
 * <p>
 * If n is <= 0 then return the input text.
 * </p>
 * 
 * 
 * <ul>
 * This kata is part of the Simple Encryption Series:
 * </ul>
 * <li>Simple Encryption #1 - Alternating Split</li>
 * <li>Simple Encryption #2 - Index-Difference</li>
 * <li>Simple Encryption #3 - Turn The Bits Around</li>
 * <li>Simple Encryption #4 - Qwerty</li>
 * 
 * @author ga.omar
 */
public class EncryptDecrypt {

	public static void main(String[] args) {
		System.out.println(encrypt("This is a test!", 2));
		System.out.println(decrypt("s eT ashi tist!", 2));
	}

	public static String encrypt(final String text, final int n) {
		if (null == text || text.isEmpty() || n <= 0)
			return text;
		int count = 0;
		String first = "", second = "", encryptedStr = text;
		while (count < n) {
			for (int i = 0; i < encryptedStr.length(); i++) {
				if (i % 2 != 0) {
					first += encryptedStr.charAt(i);
				} else {
					second += encryptedStr.charAt(i);
				}
			}
			count++;
			encryptedStr = first + second;
			first = second = "";
		}
		return encryptedStr;
	}

	public static String decrypt(final String encryptedText, final int n) {
		if (null == encryptedText || encryptedText.isEmpty() || n <= 0)
			return encryptedText;
		int count = 0;
		String tempStr = encryptedText, decrypt = "";
		while (count < n) {
			String first = tempStr.substring(0, tempStr.length() / 2);
			String second = tempStr.substring(tempStr.length() / 2);
			for (int i = 0; i < tempStr.length(); i++) {
				if (i % 2 != 0) {
					decrypt += first.charAt(0);
					first = first.substring(1);
				} else {
					decrypt += second.charAt(0);
					second = second.substring(1);
				}
			}
			count++;
			tempStr = decrypt;
			decrypt = "";
		}
		return tempStr;
	}

}
