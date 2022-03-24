package StackCalculator;

import StackCalculator.Exceptions.*;
import StackCalculator.Structures.LinkedStack;

import java.util.EmptyStackException;

public class PostfixCalculator {

	private static LinkedStack<Integer> memStack = new LinkedStack<Integer>();
	
	/**
	 * Returns a number to a power.
	 * @param numOne - The base number
	 * @param numTwo - The power
	 * @return int - the resulting number
	 */
	private static int pow(int numOne, int numTwo) {
		int result = 1;
		for (int i = 0; i < numTwo; i++) {
			result *= numOne;
		}
		return result;
	}

	/**
	 * Returns a number to the tetration
	 * @param numOne - The base number
	 * @param numTwo - The height of the tetration
	 * @return int - the resulting number
	 */
	private static int tet(int numOne, int numTwo) {
		int pow = numOne;
		for (int i = 1; i < numTwo; i++) {
				pow = pow(numOne, pow);
			}
			return pow;
		}
	
	/**
	 * Performs an operation on the stack
	 * @param c - The operation to perform
	 * @throws Exception Throws if the given operator or Equation is not valid
	 */
	private static void operate(String c) throws InvalidExpressionException, InvalidOperatorException {
		int digitOne;
		int digitTwo;
		
		try {
			digitTwo = memStack.pop();
			digitOne = memStack.pop();
		}
		catch (EmptyStackException e){
			throw new InvalidExpressionException(memStack);
		}

		if (c.equals("+")) {
			memStack.push(digitOne + digitTwo);
			return;
		}
		else if (c.equals("-")) {
			memStack.push(digitOne - digitTwo);
			return;
		}
		else if (c.equals("*")) {
			memStack.push(digitOne * digitTwo);
			return;
		}
		else if (c.equals("/")) {
			try {
				memStack.push(digitOne / digitTwo);
				return;
			}
			catch (ArithmeticException e) {
				throw new InvalidExpressionException(memStack);
			}
		}
		else if (c.equals("%")) {
			memStack.push(digitOne % digitTwo);
		}
		else if (c.equals("**")) {
			memStack.push(pow(digitOne, digitTwo));
			return;
		}
		else if (c.equals("***")) {
			memStack.push(tet(digitOne, digitTwo));
		}

		else {
			throw new InvalidOperatorException(c);
		}

	}

	/**
	 * Calculates the numerical answer from a given string
	 * @param equation - The equation in postfix notation
	 * @return Integer - The resulting number
	 */
	public static Integer calculate(String equation) {

		while (!memStack.isEmpty()) {
			memStack.pop();
		}

		for (String num : equation.split(" ")) {
			try {
				memStack.push(Integer.parseInt(num));
			}
			catch (NumberFormatException e) {
				try {
					operate(num);
				}
				catch (InvalidExpressionException ee) {
					System.out.println(ee);
					return null;
				}
				catch (InvalidOperatorException ee) {
					System.out.println(ee);
					return null;
				}
			}
		}
		int result = memStack.pop();
		
		if (!memStack.isEmpty()) {
			System.out.println(new InvalidExpressionException(memStack));
			return null;
		}
		else {
			return result;
		}

	}

}