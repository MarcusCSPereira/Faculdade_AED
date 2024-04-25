	import java.util.Stack;
public class PosFixaToInfixa {

	    public static String posfixaParaInfixa(String expressaoPosfixa) {
	        Stack<String> pilha = new Stack<>();
	        
	        // Divide a expressão em tokens baseados em espaços
	        String[] tokens = expressaoPosfixa.split("\\s");

	        for (String token : tokens) {
	            // Se o token for um operador, desempilha dois operandos, forma uma expressão infixa e empilha novamente
	            if (token.matches("[+\\-*/]")) {
	                String operando2 = pilha.pop(); // Segundo operando
	                String operando1 = pilha.pop(); // Primeiro operando
	                // Forma uma nova expressão infixa e empilha
	                String novaExpressao = "(" + operando1 + " " + token + " " + operando2 + ")";
	                pilha.push(novaExpressao);
	            } else {
	                // Se for um número, empilha diretamente
	                pilha.push(token);
	            }
	        }

	        // O resultado final na pilha é a expressão infixa
	        return pilha.pop();
	    }

	    public static void main(String[] args) {
	        String expressaoPosfixa = "y z * w x - /";
	        String expressaoInfixa = posfixaParaInfixa(expressaoPosfixa);
	        System.out.println("Expressão PosFixa: " +expressaoPosfixa) ;
	        System.out.println("Expressão Infixa: " + expressaoInfixa);
	    }
	}
