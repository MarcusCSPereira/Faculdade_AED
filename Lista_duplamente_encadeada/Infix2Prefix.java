import java.util.Stack;
public class Infix2Prefix {

	    @SuppressWarnings("unused")
      private static boolean isOperator(char c) {
	        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	    }

	    private static int getPrecedence(char c) {
	        switch (c) {
	            case '+':
	            case '-':
	                return 1;
	            case '*':
	            case '/':
	                return 2;
	            case '^':
	                return 3;
	        }
	        return -1;
	    }

	    private static String infixToPostfix(String expression) {
	        String result = "";
	        Stack<Character> stack = new Stack<>();

	        for (int i = 0; i < expression.length(); ++i) {
	            char c = expression.charAt(i);

	            if (Character.isLetterOrDigit(c)) {
	                result += c;
	            } else if (c == '(') {
	                stack.push(c);
	            } else if (c == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(') {
	                    result += stack.pop();
	                }
	                stack.pop();
	            } else {
	                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
	                    result += stack.pop();
	                }
	                stack.push(c);
	            }
	        }

	        while (!stack.isEmpty()) {
	            if (stack.peek() == '(') {
	                return "Invalid Expression";
	            }
	            result += stack.pop();
	        }

	        return result;
	    }

	    private static String reverseString(String str) {
	        String reversed = new StringBuilder(str).reverse().toString();
	        return reversed.replace('(', 't').replace(')', '(').replace('t', ')');
	    }

	    public static String infixToPrefix(String expression) {
	        String reversedExpression = reverseString(expression);
	        String postfix = infixToPostfix(reversedExpression);
	        return reverseString(postfix);
	    }

	    public static void main(String[] args) {
	        String exp = "(c/d)*(a+b)";
	        System.out.println("Infix expression: " + exp);
	        System.out.println("Prefix expression: " + infixToPrefix(exp));
	    }
	}