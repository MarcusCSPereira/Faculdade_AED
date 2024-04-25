package Pilha;

public interface IPilha<T> {

    public void push(T o) throws PilhaCheiaException;
    public T pop() throws PilhaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException;
    public T getTop() throws PilhaVaziaException, ListaVaziaException;
    public boolean isEmpty();
    public int size();
    public void clear();
}