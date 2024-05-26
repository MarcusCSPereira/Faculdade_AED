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

    for (int i = 0; i < hF.m; i++) {
      if (hF.tabelaHash[i] != null) {
        System.out.println(hF.tabelaHash[i].StringK());
      } else
        System.out.println("-------");
    }
    System.out.println();

    hF.remover("Antonio");

    hF.imprimir();

    //TODO:  Segunda-feira, consultar hélio por que da remoção de Helio não está funcionando, por conta que o método de remover node retorna o node como um resultado, e não como null;

  }
}
