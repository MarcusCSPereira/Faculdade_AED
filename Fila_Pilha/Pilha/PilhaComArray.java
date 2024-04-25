package Pilha;

public class PilhaComArray<T> implements IPilha<T> {

  private T[] array;
  private int count;

  @SuppressWarnings("unchecked")
  public PilhaComArray(int tam) {
    count = 0;
    array = (T[]) new Object[tam];
  }

  @Override
  public void push(T o) throws PilhaCheiaException {
    if (count == array.length) {
      throw new PilhaCheiaException();
    }
    array[count] = o;
    count++;
  }

  @Override
  public T pop() throws PilhaVaziaException {
    if (count == 0) {
      throw new PilhaVaziaException();
    }
    count--;
    return array[count];
  }

  @Override
  public T getTop() throws PilhaVaziaException {
    if (count == 0) {
      throw new PilhaVaziaException();
    }
    return array[count - 1];
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
    count = 0;
  }

}
