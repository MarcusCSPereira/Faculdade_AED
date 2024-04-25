package Fila;

public class FilaComListaEncadeada<T> implements IFila<T>{

  private ListaEncadeada<T> lista;
  private int count;

  public FilaComListaEncadeada() {
    lista = new ListaEncadeada<T>();
    count = 0;
  }


  @Override
  public void enqueue(T o) throws FilaCheiaException {
    lista.inserirFim(o);
    count++;
  }

  @Override
  public T dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0)
      throw new FilaVaziaException();

    T result = lista.getPrimeiro();
    lista.extrair(result);
    count --;
    return result;
  }

  @Override
  public T getFront() throws FilaVaziaException, ListaVaziaException, ContainerVazioException {
    if (count == 0)
      throw new ContainerVazioException();
      
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
