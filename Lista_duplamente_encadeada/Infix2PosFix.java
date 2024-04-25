	import java.util.Stack;
	
public class Infix2PosFix {

	    // Método para verificar se o caractere é um operador
	    private static boolean isOperator(char c) {
	        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	    }

	    // Método para verificar a precedência dos operadores
	    private static int precedence(char c) {
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

	    // Método para converter expressão infixa em posfixa
	    public static String infixToPostfix(String expression) {
	        String result = "";
	        Stack<Character> stack = new Stack<>();
	        
	        for (int i = 0; i < expression.length(); ++i) {
	            char c = expression.charAt(i);

	            // Se o caractere for um operando, adicione-o ao resultado
	            if (Character.isLetterOrDigit(c)) {
	                result += c;
	            } 
	            // Se o caractere for '(', empilhe
	            else if (c == '(') {
	                stack.push(c);
	            } 
	            // Se o caractere for ')', desempilhe até encontrar '('
	            else if (c == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(')
	                    result += stack.pop();
	                
	                stack.pop();
	            } 
	            // Um operador é encontrado
	            else if (isOperator(c)) {
	                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
	                    result += stack.pop();
	                }
	                stack.push(c);
	            }
	        }

	        // Desempilhar os operadores restantes
	        while (!stack.isEmpty()) {
	            if(stack.peek() == '(')
	                return "Expressão Inválida";
	            result += stack.pop();
	        }
	        
	        return result;
	    }

	    public static void main(String[] args) {
	        String expression = "(c/d)*(a+b)";
	        System.out.println("Expressão Infixa: " + expression);
	        System.out.println("Expressão Posfixa: " + infixToPostfix(expression));
	    }
	}
	