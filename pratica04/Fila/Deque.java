package Fila;

public class Deque<T> implements IFila<T>{

  private ListaEncadeada<T> lista;
  private int count;

  public Deque() {
    lista = new ListaEncadeada<T>();
    count = 0;
  }

  public void imprime() {
    lista.imprimirLista();
  }

  @Override
  public void enqueue(T o) throws FilaCheiaException {
    lista.inserirFim(o);
    count++;
  }

  public void addFront(T o) throws FilaCheiaException {
    lista.inserirInicio(o);
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

  public T removeBack() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0)
      throw new FilaVaziaException();

    T result = lista.getUltimo();
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

  public T getBack() throws FilaVaziaException, ListaVaziaException, ContainerVazioException {
    if (count == 0)
      throw new ContainerVazioException();
      
    return lista.getUltimo();
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public int size() {
    System.out.print("Tamanho da fila: ");
    return count;
  }

  @Override
  public void clear() {
    lista.fazVazia();
    count = 0;
  }
  
}
