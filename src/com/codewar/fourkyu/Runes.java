package com.codewar.fourkyu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * To give credit where credit is due: This problem was taken from the
 * ACMICPC-Northwest Regional Programming Contest. Thank you problem writers.
 * </p>
 * <p>
 * You are helping an archaeologist decipher some runes. He knows that this
 * ancient society used a Base 10 system, and that they never start a number
 * with a leading zero. He's figured out most of the digits as well as a few
 * operators, but he needs your help to figure out the rest.
 * </p>
 * <p>
 * The professor will give you a simple math expression, of the form
 * </p>
 * <p>
 * [number][op][number]=[number]
 * </p>
 * <p>
 * He has converted all of the runes he knows into digits. The only operators he
 * knows are addition (+),subtraction(-), and multiplication (*), so those are
 * the only ones that will appear. Each number will be in the range from
 * -1000000 to 1000000, and will consist of only the digits 0-9, possibly a
 * leading -, and maybe a few ?s. If there are ?s in an expression, they
 * represent a digit rune that the professor doesn't know (never an operator,
 * and never a leading -). All of the ?s in an expression will represent the
 * same digit (0-9), and it won't be one of the other given digits in the
 * expression. No number will begin with a 0 unless the number itself is 0,
 * therefore 00 would not be a valid number.
 * </p>
 * <p>
 * Given an expression, figure out the value of the rune represented by the
 * question mark. If more than one digit works, give the lowest one. If no digit
 * works, well, that's bad news for the professor - it means that he's got some
 * of his runes wrong. output -1 in that case.
 * </p>
 * <p>
 * Complete the method to solve the expression to find the value of the unknown
 * rune. The method takes a string as a paramater repressenting the expression
 * and will return an int value representing the unknown rune or -1 if no such
 * rune exists.
 * </p>
 * 
 * @author ga.omar
 *
 */
public class Runes {

	public static void main(String[] args) {
		// System.out.println(solveExpression("1+1=?"));
		// System.out.println(solveExpression("123*45?=5?088"));
		// System.out.println(solveExpression("-5?*-1=5?"));
		// System.out.println(solveExpression("19--45=5?"));
		System.out.println(solveExpression("-7715?5--484?00=-28?9?5"));
		System.out.println(solveExpression("123?45-?=123?45"));

	}

	public static int solveExpression(final String expression) {
		int missingDigit = -1;

		List<Integer> digitAbsent = getAbsentDigit(expression);

		String lhs = expression.substring(0, expression.indexOf("="));
		String rhs = expression.substring(expression.indexOf("=") + 1, expression.length());

		for (Integer integer : digitAbsent) {
			System.out.println(evaluateLHS(lhs, integer) + "     " + (evaluateRHS(rhs, integer)));
			if (evaluateLHS(lhs, integer).equals(evaluateRHS(rhs, integer))) {
				missingDigit = integer;
				break;
			}
		}
		return missingDigit;
	}

	private static List<Integer> getAbsentDigit(String expression) {
		List<Integer> digitPresent = new ArrayList<>();
		for (int i = 0; i <= expression.length(); i++) {
			try {
				int num = Integer.parseInt(expression.charAt(i) + "");
				if (!digitPresent.contains(num))
					digitPresent.add(num);
			} catch (Exception e) {
			}
		}
		List<Integer> digitAbsent = new ArrayList<>();
		for (int i = 0; i <= 9; i++) {
			if (!digitPresent.contains(i))
				digitAbsent.add(i);
		}
		return digitAbsent;
	}

	private static String evaluateLHS(String lhs, int digitToCheck) {
		lhs = lhs.replaceAll("\\?", String.valueOf(digitToCheck));

		int posOfAdd = lhs.indexOf("+");
		int posOfMul = lhs.indexOf("*");
		int posOfSub = lhs.indexOf("-") == 0 ? lhs.substring(1, lhs.length()).indexOf("-") + 1 : lhs.indexOf("-");
		int firstNum = 0;
		int secondNum = 0;
		String operator = "";
		String result = "";

		if (posOfAdd > 0) {
			firstNum = Integer.parseInt(lhs.substring(0, posOfAdd));
			secondNum = Integer.parseInt(lhs.substring(posOfAdd + 1, lhs.length()));
			operator = "+";
		} else if (posOfMul > 0) {
			firstNum = Integer.parseInt(lhs.substring(0, posOfMul));
			secondNum = Integer.parseInt(lhs.substring(posOfMul + 1, lhs.length()));
			operator = "*";
		} else if (posOfSub > 0) {
			firstNum = Integer.parseInt(lhs.substring(0, posOfSub));
			secondNum = Integer.parseInt(lhs.substring(posOfSub + 1, lhs.length()));
			operator = "-";
		}
		switch (operator) {
		case "+":
			result = "" + (firstNum + secondNum);
			break;
		case "-":
			result = "" + (firstNum - secondNum);
			break;
		case "*":
			result = "" + (firstNum * secondNum);
			break;
		}
		return result;
	}

	private static String evaluateRHS(String rhs, int digitToCheck) {
		rhs = rhs.replaceAll("\\?", String.valueOf(digitToCheck));
		return rhs;
	}

}
