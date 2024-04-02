package Pilha;

public interface Pilha {

    public void push(Object o) throws PilhaCheiaException;
    public Object pop() throws PilhaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException;
    public Object getTop() throws PilhaVaziaException, ListaVaziaException;
    public boolean isEmpty();
    public int size();
    public void clear();
}