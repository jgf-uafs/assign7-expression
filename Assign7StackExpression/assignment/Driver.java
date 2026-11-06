package assignment;

public class Driver {
    public static void main(String[] args) {
    	ExpressionEvaluator test = new ExpressionEvaluator();
    	
    	System.out.println(test.infixToPostfix("(2 + 3) * 2 - ( 2 * 2 )"));
    }
}

