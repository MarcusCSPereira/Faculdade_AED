public class TesteAVL {
  public static void main(String[] args) {
    AVL_Helio<Integer> arvoreAVL = new AVL_Helio<Integer>(1);
    arvoreAVL = arvoreAVL.InsereOrdenado(2, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(3, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(4,null);
    arvoreAVL = arvoreAVL.InsereOrdenado(5, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(6, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(7, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(8, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(9, null);
    arvoreAVL = arvoreAVL.InsereOrdenado(11, null);

    System.out.println("=============================================");
    System.out.println("Impressão em Ordem");
    arvoreAVL.imprimeInOrdem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão Pré Ordem");
    arvoreAVL.imprimeEmPreordem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão Pós Ordem");
    arvoreAVL.imprimeEmPosordem();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão em Largura");
    arvoreAVL.imprimeEmLargura();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Impressão em Largura Invertido");
    arvoreAVL.imprimeEmLarguraInvertido();
    System.out.println();

    System.out.println("=============================================");
    System.out.println("Método de busca:");
    System.out.println("Busca 7: " + arvoreAVL.pesquisarValor(7));

    System.out.println("=============================================");
    System.out.println("Método de calcular altura:");
    System.out.println("Altura da árvore: " + arvoreAVL.calculaAltura());

    System.out.println("=============================================");
    System.out.println("Método de calcular total de nós:");
    System.out.println("Total de nós: " + arvoreAVL.calculaTotalNodes());

    System.out.println("=============================================");
    System.out.println("Método de calcular total de nós folha:");
    System.out.println("Total de nós folha: " + arvoreAVL.calculaTotalNodesFolhas());

    System.out.println("=============================================");
    System.out.println("Removendo Nodes:");
    System.out.println();
    System.out.println("Arvore antes de remover o 11:");
    arvoreAVL.imprimeInOrdem();
    System.out.println();
    arvoreAVL.removerNode(11, arvoreAVL.acharPai(arvoreAVL.pesquisarValor(11)));
    System.out.println();
    System.out.println("Arvore depois de remover o 11:");
    arvoreAVL.imprimeInOrdem();
    System.out.println();
    System.out.println("=============================================");

  }
}
