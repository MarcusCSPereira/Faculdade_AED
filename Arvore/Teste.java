public class Teste {
  public static void main(String[] args) {

    Node<Integer> raiz = new Node<Integer>(10);

    raiz.inserirOrdenado(5);
    raiz.inserirOrdenado(15);
    raiz.inserirOrdenado(3);
    raiz.inserirOrdenado(7);

    System.out.println("In Ordem");
    raiz.imprimirInOrdem();
    System.out.println();
    System.out.println("Pre Ordem");
    raiz.imprimirPreOrdem();
    System.out.println();
    System.out.println("Pos Ordem");
    raiz.imprimirPosOrdem();
    System.out.println();
    System.out.println("Em Largura");
    raiz.imprimirEmLargura();
    System.out.println();
    
    System.out.println();
    System.out.println("Buscando 3: " + raiz.buscar(3));
    System.out.println("Buscando 7: " + raiz.buscar(7));
    System.out.println("Buscando 10: " + raiz.buscar(10));
    System.out.println();

    raiz.imprimirArvore();

    System.out.println();
    System.out.println("Removendo 5");
    raiz.remover(5);
    System.out.println();

    raiz.imprimirArvore();



  }
}
