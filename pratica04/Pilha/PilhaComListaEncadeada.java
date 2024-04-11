package Pilha;

public class PilhaComListaEncadeada<T> implements IPilha<T> {

  private ListaEncadeada<T> lista;
  private int count;

  public PilhaComListaEncadeada() {
    lista = new ListaEncadeada<>();
    count = 0;
  }

  @Override
  public void push(T element) throws PilhaCheiaException {
    lista.inserirInicio(element);
    count++;
  }

  @Override
  public T pop() throws PilhaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0)
      throw new PilhaVaziaException();

    T result = lista.getPrimeiro();
    lista.extrair(result);
    count--;
    return result;
  }

  @Override
  public T getTop() throws PilhaVaziaException, ListaVaziaException {
    if (count == 0)
      throw new PilhaVaziaException();
    return lista.getPrimeiro();
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
    lista.fazVazia();
    count = 0;
  }
  


}
