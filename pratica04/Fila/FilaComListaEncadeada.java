package Fila;

public class FilaComListaEncadeada implements Fila{

  private ListaEncadeada lista;
  private int count;

  public FilaComListaEncadeada() {
    lista = new ListaEncadeada();
    count = 0;
  }


  @Override
  public void enqueue(Object o) throws FilaCheiaException {
    lista.inserirFim(o);
    count++;
  }

  @Override
  public Object dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0)
      throw new FilaVaziaException();

    Object result = lista.getPrimeiro();
    lista.extrair(result);
    count --;
    return result;
  }

  @Override
  public Object getFront() throws FilaVaziaException, ListaVaziaException, ContainerVazioException {
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
