public class ListaDuplamenteEncadeada {

  private Element head;

  private Element tail;

  public final class Element {

    Object data;
    Element next, prev;

    Element(Object d, Element p, Element n) {
      data = d;
      next = n;
      prev = p;
    }

    public void inserirDepois(Object item) {

      Element temp = new Element(item, this, next);
      next = temp;

      if (tail == this) {
        tail = next;
      } else {
        temp.next.prev = temp;
      }

    }

    public void inserirAntes(Object item) {

      Element temp = new Element(item, prev, this);
      prev = temp;

      if (this == head) {
        head = prev;
      } else {
        temp.prev.next = temp;
      }
    }

  }

  public void inserirInicio(Object item) {

    Element temp = new Element(item, null,head);

    if (head == null) {
      tail = temp;

    } else {
      head.prev = temp;

    }
    head = temp;
  }

  public void inserirFim(Object item) {

    Element temp = new Element(item, tail,null);

    if (head == null) {
      head = temp;
    } else {
      tail.next = temp;
    }
    tail = temp;

  }

  public void remover(Object item) throws ObjetoNaoEncontradoException {

    Element ptr = head;

    while (ptr != null && ptr.data != item) {
      ptr = ptr.next;
    }

    if (ptr == null) {
      throw new ObjetoNaoEncontradoException();
    }

    if(ptr != head && ptr != tail) {
      (ptr.prev).next = ptr.next;
      (ptr.next).prev = ptr.prev;
    }
    
    if (ptr == head) {
      head = ptr.next;
      head.prev = null;
    }

    if (ptr == tail) {
      tail = ptr.prev;
      tail.next = null;

    } 

  }

  public void imprimir() throws ListaVaziaException {

    Element ptr = head;

    if(isVazia()){
      throw new ListaVaziaException();
    }
    System.out.print("Lista: ");
    while (ptr != null) {
      System.out.print(ptr.data + " | ");
      ptr = ptr.next;
    }
    System.out.println();

  }

  public boolean isVazia() {
    return head == null;
  }

  public void getTamanho() throws ListaVaziaException {

    Element ptr = head;
    int count = 0;

    if(isVazia()){
      throw new ListaVaziaException();
    }

    while (ptr != null) {
      count++;
      ptr = ptr.next;
    }

    System.out.println("Tamanho da lista: " + count);

  }

}
