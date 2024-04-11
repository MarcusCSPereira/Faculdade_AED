public class ListaEncadeada<T> {

  public Element<T> head;
  public Element<T> tail;

  public void addInicio(T data){
    if(head == null){
      Element<T> novo = new Element<T>(data);
      head=novo;
      tail=novo;
    } else {
      Element<T> novo = new Element<T>(data);
      novo.setNext(head);
      head = novo;
    }
  }

  public void addFinal(T data){
    Element<T> temp = new Element<T>(data);
    if(head == null){
      head = new Element<T>(data);
      tail=head;
    } else {
      tail.setNext(temp);
      tail = temp;
    }
  }

  public void removeInicio(){
    if(head == null){
      return;
    } else {
      head = head.getNext();
    }
  }

  public void remove(T data){
    Element<T> vouRemover = new Element<T>(data);
    if(head == null){
      return;
    }
    if(head == vouRemover){
      head = head.getNext();
    } else {
      Element<T> ptr = head;
      while (ptr.getNext() != vouRemover) {
        ptr=ptr.getNext();
      }
      ptr.setNext(vouRemover.getNext());
    }
  }

  public void removeFinal(){
    if(head == null){
      return;
    } else {
      Element<T> ptr = head;
      while(ptr.getNext() != tail){
        ptr = ptr.getNext();
      }
      ptr.setNext(null);
      tail = ptr;
    }
  }

  public void inserirAntes(Element<T> existente, Element<T> novo){
    if(existente == head){
      this.addInicio(novo.getData());
    }else{
      Element<T> ptr = head;
      while(ptr != null){
        if(ptr.getNext() == existente){
          novo.setNext(ptr.getNext());
          ptr.setNext(novo);
          break;
        }
        ptr = ptr.getNext();
      }
    }
  }

  public void inserirDepois(Element<T> existente, Element<T> novo){
    novo.setNext(existente.getNext());
    existente.setNext(novo);
  }

  public void fazVazia(){
    Element<T> ptr = head;
    while(ptr != null){
      Element<T> temp = ptr.getNext();
      ptr.setNext(null);
      ptr = temp;
    }
  }

  public int buscaPorElemento(T data){
    Element<T> ptr = head;
    int count = 1;
    while(ptr != null){
      if(ptr.getData().equals(data)){
        return count;
      }
      count++;
      ptr = ptr.getNext();
    }
    return -1;
  }

  public Element<T> buscaPorPosicao(int pos){
    Element<T> ptr = head;
    int count = 1;
    while(ptr != null){
      if(count == pos){
        return ptr;
      }
      count++;
      ptr = ptr.getNext();
    }
    return null;
  }

  public void percorrerLista(){
    Element<T> ptr = this.head;
    while(ptr!=null){
      System.out.println(ptr);
      ptr = ptr.getNext();
    }
  }



  public int tamanho(){
    if (head == null) {
      return 0;
    } else {
      Element<T> temp = head;
      int count = 0;
      while(temp != null){
        count++;
        temp = temp.getNext();
      }
      return count;
    }
  }
  
}