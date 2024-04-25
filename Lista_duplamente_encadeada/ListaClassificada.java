public class ListaClassificada<T> {

  private Element head;
  private Element tail;

  public final class Cursor {

    private Element element;

    Cursor(Element element) {
      this.element = element;
    }

    public Element getElement() {
      return element;
    }

    public void setElement(Element element) {
      this.element = element;
    }

  }

  public final class Element {
    private T data;
    private Element next;
    private Element prev;

    public Element(T data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    public T getData() {

      return this.data;
    }

    public int comparesTo(T object) throws TipoDeObjetoNPermitidoException {

      if (object instanceof Integer) {

        if ((Integer) this.getData() < (Integer) object) {
          return -1;
        }
        if ((Integer) this.getData() == (Integer) object) {
          return 0;
        }
        if ((Integer) this.getData() > (Integer) object) {
          return 1;
        }

      } else if (object instanceof String) {

        if (((String) this.getData()).compareToIgnoreCase((String) object) < 0) {
          return -1;
        }
        if (((String) this.getData()).compareToIgnoreCase((String) object) == 0) {
          return 0;
        }
        if (((String) this.getData()).compareToIgnoreCase((String) object) > 0) {
          return 1;
        }

      } else if (object instanceof Float) {

        if (((Float) this.getData() < (Float) object)) {
          return -1;
        }
        if (((Float) this.getData() == (Float) object)) {
          return 0;
        }
        if (((Float) this.getData() > (Float) object)) {
          return 1;
        }

      } else if (object instanceof Double) {

        if (((Double) this.getData() < (Double) object)) {
          return -1;
        }
        if (((Double) this.getData() == (Double) object)) {
          return 0;
        }
        if (((Double) this.getData() > (Double) object)) {
          return 1;
        }

      }
      throw new TipoDeObjetoNPermitidoException();
    }

    public Element getNext() {
      return this.next;
    }

    public Element getPrev() {
      return this.prev;
    }

    public void setNext(Element next) {
      this.next = next;
    }

    public void setPrev(Element prev) {
      this.prev = prev;
    }
  }

  public ListaClassificada() {
    this.head = null;
    this.tail = null;
  }

  private void inserirInicio(T data) {
    Element novo = new Element(data);
    if (this.head == null) {
      this.head = novo;
      this.tail = novo;
    } else {
      novo.setNext(this.head);
      this.head.setPrev(novo);
      this.head = novo;
    }
  }

  public void inserirFim(T data) {
    Element novo = new Element(data);
    if (this.head == null) {
      this.head = novo;
      this.tail = novo;
    } else {
      this.tail.setNext(novo);
      novo.setPrev(this.tail);
      this.tail = novo;
    }
  }

  public void inserir(T data) throws TipoDeObjetoNPermitidoException {

    Element novo = new Element(data);
    Cursor cursor = new Cursor(novo);
    if (this.head == null) {
      if (!(data instanceof Integer) && !(data instanceof String) && !(data instanceof Float)
          && !(data instanceof Double)) {
        throw new TipoDeObjetoNPermitidoException();
      }
      this.inserirInicio(data);
      return;
    }

    if ((cursor.getElement().comparesTo(head.getData()) <= 0)) {
      this.inserirInicio(novo.getData());
      return;
    }

    if ((tail).comparesTo(cursor.getElement().getData()) <= 0) {
      this.inserirFim(novo.getData());
      return;
    }

    Element ptr = head;
    while (ptr != null) {
      if (cursor.getElement().comparesTo(ptr.getData()) <= 0) {
        ptr.getPrev().setNext(novo);
        ptr.setPrev(novo);
        novo.setNext(ptr);
        return;
      }
      ptr = ptr.getNext();
    }
  }

  public void imprimir() {
    Element aux = this.head;
    System.out.println("Lista do tipo " + this.head.getData().getClass().getSimpleName() + ": ");
    while (aux != null) {
      System.out.print(aux.getData() + " | ");
      aux = aux.getNext();
    }
    System.out.println();
    System.out.println();
  }

  public void remover(T data) throws ObjetoNaoEncontradoException, ListaVaziaException {
    if (this.head == null) {
      throw new ListaVaziaException();
    } else {
      Element aux = this.head;
      while (aux != null) {
        if (aux.getData().equals(data)) {
          if (aux == this.head) {
            this.head = aux.getNext();
            if (this.head != null) {
              this.head.setPrev(null);
            }
          } else if (aux == this.tail) {
            this.tail = aux.getPrev();
            if (this.tail != null) {
              this.tail.setNext(null);
            }
          } else {
            aux.getPrev().setNext(aux.getNext());
            aux.getNext().setPrev(aux.getPrev());
          }
          return;
        }
        aux = aux.getNext();
      }
      throw new ObjetoNaoEncontradoException();
    }
  }

  public int getTamanho() {
    Element aux = this.head;
    int tamanho = 0;
    while (aux != null) {
      tamanho++;
      aux = aux.getNext();
    }
    return tamanho;
  }

}
