package Fila;

public class FilaComArray<T> implements IFila<T> {

  private T[] array;
  private int count, head, tail;

  @SuppressWarnings("unchecked")
  public FilaComArray(int tam) {
    array = (T[])(new Object[tam]);
    head = 0;
    tail = 0;
    count = 0;
  }

  @Override
  public void enqueue(T o) throws FilaCheiaException {
    if (count == array.length) {
      throw new FilaCheiaException();
    }
    array[count] = o;
    tail = count;
    count++;
  }

@Override
public T dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0) {
        throw new FilaVaziaException();
    }
    T obj = array[head];
    array[head] = null;
    for (int i = head + 1; i <= tail ; i++) {
        array[i - 1] = array[i];
    }
    count--;
    return obj;
}


  @Override
  public T getFront() throws FilaVaziaException, ListaVaziaException {
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
