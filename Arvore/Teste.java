public class Teste {
  public static void main(String[] args) {

    Node<Integer> raiz = new Node<Integer>(10);

    raiz.inserirOrdenado(5);
    raiz.inserirOrdenado(3);
    raiz.inserirOrdenado(7);
    raiz.inserirOrdenado(12);
    raiz.inserirOrdenado(11);
    raiz.inserirOrdenado(4);
    raiz.inserirOrdenado(15);
    raiz.inserirOrdenado(13);
    raiz.inserirOrdenado(17);

    System.out.println("=============================================");
    System.out.println("Impressão em Ordem");
    raiz.imprimeInOrdem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão Pré Ordem");
    raiz.imprimeEmPreordem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão Pós Ordem");
    raiz.imprimeEmPosordem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão em Largura");
    raiz.imprimeEmLargura();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão em Largura Invertido");
    raiz.imprimeEmLarguraInvertido();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Método de busca:");
    System.out.println("Busca 7: " + raiz.pesquisarValor(7));

    System.out.println("=============================================");
    System.out.println("Método de calcular altura:");
    System.out.println("Altura da árvore: " + raiz.calculaAltura());

    System.out.println("=============================================");
    System.out.println("Método de calcular total de nós:");
    System.out.println("Total de nós: " + raiz.calculaTotalNodes());

    System.out.println("=============================================");
    System.out.println("Método de calcular total de nós folha:");
    System.out.println("Total de nós folha: " + raiz.calculaTotalNodesFolhas());

    System.out.println("=============================================");
    System.out.println("Removendo Nodes:");
    System.out.println();
    System.out.println("Arvore antes de remover o 11:");
    raiz.imprimeInOrdem();
    System.out.println();
    raiz.removerNode(11, raiz.acharPai(raiz.pesquisarValor(11)));
    System.out.println();
    System.out.println("Arvore depois de remover o 11:");
    raiz.imprimeInOrdem();
    System.out.println();
    System.out.println("=============================================");
  }
}
