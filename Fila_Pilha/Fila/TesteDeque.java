package Fila;

public class TesteDeque {
  public static void main(String[] args) {
    
    Deque<Integer> deque = new Deque<Integer>();

    try {
      deque.enqueue(2);
      deque.enqueue(3);
      deque.addFront(1);
      deque.addFront(0);

      deque.imprime();

      System.out.println(deque.size());

      System.out.println(deque.dequeue());
      System.out.println(deque.removeBack());

      System.out.println(deque.getFront());
      System.out.println(deque.getBack());

      System.out.println(deque.isEmpty());

      deque.clear();

      System.out.println(deque.isEmpty());

    } catch (FilaCheiaException | FilaVaziaException | ListaVaziaException | ObjetoNaoEncontradoException | ContainerVazioException e) {
      e.printStackTrace();
    }



  }
}
