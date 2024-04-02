package Pilha;

public class PilhaComArray implements Pilha {

  private Object[] array;
  private int count;

  public PilhaComArray(int tam) {
    count = 0;
    array = new Object[tam];
  }

  @Override
  public void push(Object o) throws PilhaCheiaException {
    if (count == array.length) {
      throw new PilhaCheiaException();
    }
    array[count] = o;
    count++;
  }

  @Override
  public Object pop() throws PilhaVaziaException {
    if (count == 0) {
      throw new PilhaVaziaException();
    }
    count--;
    return array[count];
  }

  @Override
  public Object getTop() throws PilhaVaziaException {
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
