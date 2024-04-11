public class ListaDuplamenteEncadeada<T>{

  private Element<T> head;
  private Element<T> tail;

  public class Element<E>{
    private T data;
    private Element<T> proximo;
    private Element<T> anterior;

    public Element(T data){
      this.data = data;
      this.proximo = null;
      this.anterior = null;
    }

    public T getData(){
      return this.data;
    }

    public Element<T> getproximo(){
      return this.proximo;
    }

    public Element<T> getanterior(){
      return this.anterior;
    }

    public void setproximo(Element<T> proximo){
      this.proximo = proximo;
    }

    public void setanterior(Element<T> anterior){
      this.anterior = anterior;
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
      novo.setproximo(this.head);
      this.head.setanterior(novo);
      this.head = novo;
    }
  }

  public void inserirFim(T data){
    Element<T> novo = new Element<T>(data);
    if(this.head == null){
      this.head = novo;
      this.tail = novo;
    }else{
      this.tail.setproximo(novo);
      novo.setanterior(this.tail);
      this.tail = novo;
    }
  }

  public void imprimir(){
    Element<T> aux = this.head;
    System.out.println("Lista do tipo " + this.head.getData().getClass().getName() + ": ");
    while(aux != null){
      System.out.print(aux.getData() + " | ");
      aux = aux.getproximo();
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
            this.head = aux.getproximo();
            if(this.head != null){
              this.head.setanterior(null);
            }
          }else if(aux == this.tail){
            this.tail = aux.getanterior();
            if(this.tail != null){
              this.tail.setproximo(null);
            }
          }else{
            aux.getanterior().setproximo(aux.getproximo());
            aux.getproximo().setanterior(aux.getanterior());
          }
          return;
        }
        aux = aux.getproximo();
      }
      throw new ObjetoNaoEncontradoException();
    }
  }

  public void getTamanho(){
    Element<T> aux = this.head;
    int tamanho = 0;
    while(aux != null){
      tamanho++;
      aux = aux.getproximo();
    }
    System.out.println("Tamanho: " + tamanho);
  }









}
