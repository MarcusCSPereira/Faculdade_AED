package Fila;

public interface Fila {
    public void enqueue(Object o) throws FilaCheiaException;
    public Object dequeue() throws FilaVaziaException, ListaVaziaException, ObjetoNaoEncontradoException;
    public Object getFront() throws FilaVaziaException, ListaVaziaException, ContainerVazioException;
    public boolean isEmpty();
    public int size();
    public void clear();
}
