public class ListaDuplamenteEncadeada<T>{

  private Element<T> head;
  private Element<T> tail;

  public class Element<E>{
    private T data;
    private Element<T> next;
    private Element<T> prev;

    public Element(T data){
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    public T getData(){
      return this.data;
    }

    public Element<T> getNext(){
      return this.next;
    }

    public Element<T> getPrev(){
      return this.prev;
    }

    public void setNext(Element<T> next){
      this.next = next;
    }

    public void setPrev(Element<T> prev){
      this.prev = prev;
    }
  }

  public ListaDuplamenteEncadeada(){
    this.head = null;
    this.tail = null;
  }

  public void inserirInicio(T data){
    Element<T> novo = new Element<T>(data);
    if(this.head == null){
      this.head = novo;
      this.tail = novo;
    }else{
      novo.setNext(this.head);
      this.head.setPrev(novo);
      this.head = novo;
    }
  }

  public void inserirFim(T data){
    Element<T> novo = new Element<T>(data);
    if(this.head == null){
      this.head = novo;
      this.tail = novo;
    }else{
      this.tail.setNext(novo);
      novo.setPrev(this.tail);
      this.tail = novo;
    }
  }

  public void imprimir(){
    Element<T> aux = this.head;
    while(aux != null){
      System.out.print(aux.getData() + " | ");
      aux = aux.getNext();
    }
    System.out.println();
  }

  public void remover(T data) throws ObjetoNaoEncontradoException, ListaVaziaException{
    if(this.head == null){
      throw new ListaVaziaException();
    }else{
      Element<T> aux = this.head;
      while(aux != null){
        if(aux.getData().equals(data)){
          if(aux == this.head){
            this.head = aux.getNext();
            if(this.head != null){
              this.head.setPrev(null);
            }
          }else if(aux == this.tail){
            this.tail = aux.getPrev();
            if(this.tail != null){
              this.tail.setNext(null);
            }
          }else{
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

  public void getTamanho(){
    Element<T> aux = this.head;
    int tamanho = 0;
    while(aux != null){
      tamanho++;
      aux = aux.getNext();
    }
    System.out.println("Tamanho: " + tamanho);
  }









}
