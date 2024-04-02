package Pilha;

public class PilhaComListaEncadeada implements Pilha{

  private ListaEncadeada lista;
  private int count;

  public PilhaComListaEncadeada() {
    lista = new ListaEncadeada();
    count = 0;
  }


  @Override
  public void push(Object o) throws PilhaCheiaException {
    lista.inserirInicio(o);
    count++;
  }

  @Override
  public Object pop() throws PilhaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException {
    if (count == 0)
      throw new PilhaVaziaException();

    Object result = lista.getPrimeiro();
    lista.extrair(result);
    count --;
    return result;
  }

  @Override
  public Object getTop() throws PilhaVaziaException, ListaVaziaException {
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
