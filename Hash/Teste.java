public class Teste {
  public static void main(String[] args) {
    int M = 13; // Exemplo de tamanho da tabela hash
    Hash hF = new Hash(M);
    hF.inserir("Helio");
    hF.inserir("jose");
    hF.inserir("Jose");
    hF.inserir("Antonio");
    hF.inserir("Roberto");
    hF.inserir("Hugo");

    System.out.println("\nTabela Hash: \n");

    hF.imprimir();

    System.out.println();

    hF.remover("Helio");
    hF.alterarValor("Antonio", "Fatima");

    System.out.println();

    hF.imprimir();

  }
}
