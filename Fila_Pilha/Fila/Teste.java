package Fila;

public class Teste {

  public static void main(String[] args) {
    FilaComListaEncadeada<Integer> filaEncadeada = new FilaComListaEncadeada<Integer>();
    try {


      /*filaEncadeada.enqueue(1);
      filaEncadeada.enqueue(2);
      filaEncadeada.enqueue(3);
      filaEncadeada.enqueue(4);

      System.out.println(filaEncadeada.dequeue());
      System.out.println(filaEncadeada.dequeue());
      System.out.println(filaEncadeada.getFront());

      System.out.println(filaEncadeada.isEmpty());

      filaEncadeada.clear();

      System.out.println(filaEncadeada.isEmpty());*/

      FilaComArray<Integer> filaArray = new FilaComArray<Integer>(5);

      filaArray.enqueue(1);
      filaArray.enqueue(2);
      filaArray.enqueue(3);
      filaArray.enqueue(4);

      System.out.println(filaArray.dequeue());
      System.out.println(filaArray.dequeue());
      System.out.println(filaArray.getFront());

    } catch (FilaCheiaException e) {
      e.printStackTrace();
    } catch (FilaVaziaException e) {
      e.printStackTrace();
    } catch (ListaVaziaException e) {
      e.printStackTrace();
    } catch (ObjetoNaoEncontradoException e) {
      e.printStackTrace();}
    
    
  }
}
