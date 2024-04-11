package Fila;

public interface IFila<T> {
    public void enqueue(T o) throws FilaCheiaException;
    public T dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException;
    public T getFront() throws FilaVaziaException, ListaVaziaException, ContainerVazioException;
    public boolean isEmpty();
    public int size();
    public void clear();
}
