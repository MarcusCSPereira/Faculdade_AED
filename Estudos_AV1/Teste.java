public class Teste {
  public static void main(String[] args) {
    ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();

    lista.addInicio(1);
    lista.addFinal(5);
    lista.addInicio(2);
    lista.addFinal(3);
    lista.addInicio(4);
    lista.addFinal(6);

    
    Element<Integer> novo = new Element<Integer>(8);
    lista.inserirAntes(lista.buscaPorPosicao(6), novo);
    lista.remove(1);

    lista.percorrerLista();
  
    System.out.println(lista.tamanho());
  }
}
