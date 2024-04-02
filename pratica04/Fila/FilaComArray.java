package Fila;

public class FilaComArray implements Fila {

  private Object[] array;
  private int count, head, tail;

  public FilaComArray(int tam) {
    array = new Object[tam];
    head = 0;
    tail = tam - 1;
    count = 0;
  }

  @Override
  public void enqueue(Object o) throws FilaCheiaException {
    if (count == array.length) {
      throw new FilaCheiaException();
    }
    tail = (tail + 1) % array.length;
    array[tail] = o;
    count++;
  }

  @Override
  public Object dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0) {
      throw new FilaVaziaException();
    }
    Object result = array[head];
    head = (head + 1) % array.length;
    count--;
    return result;
  }

  @Override
  public Object getFront() throws FilaVaziaException, ListaVaziaException {
    if (count == 0) {
      throw new FilaVaziaException();
    }
    return array[head];
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public void clear() {
    head = 0;
    tail = array.length - 1;
    count = 0;
  }
}
