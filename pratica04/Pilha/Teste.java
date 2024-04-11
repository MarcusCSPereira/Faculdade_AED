package Pilha;

public class Teste {
  public static void main(String[] args) {
    PilhaComListaEncadeada<Integer> pilhaEncadeada = new PilhaComListaEncadeada<Integer>();
    PilhaComArray<Integer> pilhaArray = new PilhaComArray<Integer>(4);

    try {


      pilhaEncadeada.push(1);
      pilhaEncadeada.push(2);
      pilhaEncadeada.push(3);

      System.out.println(pilhaEncadeada.pop());
      System.out.println(pilhaEncadeada.pop());
      System.out.println(pilhaEncadeada.getTop());

      System.out.println(pilhaEncadeada.isEmpty());

      pilhaEncadeada.clear();

      System.out.println(pilhaEncadeada.isEmpty());

      pilhaArray.push(1);
      pilhaArray.push(2);
      pilhaArray.push(3);

      System.out.println(pilhaArray.pop());
      System.out.println(pilhaArray.pop());
      System.out.println(pilhaArray.getTop());

      System.out.println(pilhaArray.isEmpty());

      pilhaArray.clear();

      System.out.println(pilhaArray.isEmpty());


    } catch (PilhaCheiaException | PilhaVaziaException | ListaVaziaException | ObjetoNaoEncontradoException e) {
      e.printStackTrace();
    }

  }
}
