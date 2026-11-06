package assignment;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
    	ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
    	Scanner scnr = new Scanner(System.in);
    	System.out.print("Enter an infix expression (e.g., (3 + 5) * 2): ");
    	String infix = scnr.nextLine();
    	String postfix = expressionEvaluator.infixToPostfix(infix);
    	int result = expressionEvaluator.evaluatePostfix(postfix);
    	
    	System.out.println("\n--- Results ---");
    	System.out.printf("Infix Expression:   %s\n", infix);
    	System.out.printf("Postfix Expression: %s\n", postfix);
    	System.out.printf("Evaluated Result:   %d\n", result);
    }
}

