import java.util.Scanner;

public class TesteHashAberto {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de sondagem:");
        System.out.println("1 - Linear");
        System.out.println("2 - Quadrática");
        System.out.println("3 - Dupla");
        int escolha = scanner.nextInt();

        HashAberto<String, Integer> hashAberto = new HashAberto<>(escolha);

        // Exemplo de uso
        hashAberto.put("chave1", 25);
        hashAberto.put("chave2", 53);
        hashAberto.put("chave3", 35);

        System.out.println("Valor para chave1: " + hashAberto.get("chave1"));
        System.out.println("Valor para chave2: " + hashAberto.get("chave2"));
        System.out.println("Valor para chave3: " + hashAberto.get("chave3"));

        scanner.close();
    }
}
