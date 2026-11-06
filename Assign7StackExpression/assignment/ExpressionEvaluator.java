package assignment;

import java.util.Scanner;

public class ExpressionEvaluator implements ExpressionEvaluatorInterface {

	@Override
	public String infixToPostfix(String infix) {
		Stack<Character> operatorStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if(c == ' ') continue;
			
			if(c >= '0' && c <= '9') {
				result.append(c);
				result.append(' ');
			}else if(c == '(') {
				operatorStack.push(c);
			}else if(c == ')') {
				while(operatorStack.peek() != '(' && !operatorStack.isEmpty()) {
					result.append(operatorStack.pop());
					result.append(' ');
				}
			}else {
				while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && operatorImportance(operatorStack.peek()) > operatorImportance(c) || operatorImportance(operatorStack.peek()) == operatorImportance(c) && c != '^') {
					result.append(operatorStack.pop());
					result.append(' ');
				}
				operatorStack.push(c);
			}
		}
		
		while(!operatorStack.isEmpty()) {
			if(operatorStack.peek() == '(') {
				operatorStack.pop();
			}else {
				result.append(operatorStack.pop());	
			}
		}
		return result.toString();
	}
	
	public int operatorImportance(char c) {
		if(c == '+' || c == '-') {
			return 1;
		}else if(c == '*' || c == '/') {
			return 2;
		}else if(c == '^') {
			return 3;
		}else return -1;
	}

	@Override
	public int evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		Scanner scnr = new Scanner(postfix);
		
		while(scnr.hasNext()){
			if(scnr.hasNextInt()) {
				stack.push(scnr.nextInt());
			}else {
				char c = scnr.next().charAt(0);
				if(c == '+') {
					int num2 = stack.pop();
					int num1 = stack.pop();
					stack.push(num1 + num2);
				}else if(c == '-') {
					int num2 = stack.pop();
					int num1 = stack.pop();
					stack.push(num1 - num2);
				}else if(c == '*') {
					int num2 = stack.pop();
					int num1 = stack.pop();
					stack.push(num1 * num2);
				}else if(c == '/') {
					int num2 = stack.pop();
					int num1 = stack.pop();
					stack.push(num1 / num2);
				}else if(c == '^') {
					int num2 = stack.pop();
					int num1 = stack.pop();
					stack.push((int) Math.pow(num1, num2));
				}
			}
		}
		scnr.close();
		return stack.pop();
	}

}
