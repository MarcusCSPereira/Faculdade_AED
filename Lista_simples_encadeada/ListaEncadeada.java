public class ListaEncadeada {

  private Element head;
  private Element tail;

  public final class Element {
    Object data;
    Element next;

    Element(Object d, Element n){
      data = d;
      next = n;
    }

      public Object getData(){
        return data;
      }

      public Element getNext(){
        return next;
      }

      public void inserirDepois(Object item){
        next = new Element(item, head);
        if(tail == this){
          tail=next;
        }
      }
      
      public void inserirAntes(Object item){
        Element elementoTemporario = new Element(item, this);
        if(this == head){
          head = elementoTemporario;
        }else{
          Element ponteiroAnterior = head;
          while(ponteiroAnterior!=null && ponteiroAnterior.next != this){
            ponteiroAnterior = ponteiroAnterior.next;
          }
          ponteiroAnterior.next=elementoTemporario;
        }
      }

    }

  public void fazVazia(){
    head=null;
    tail=null;
  }

  public Element getHead(){
    return head;
  }

  public Element getTail(){
    return tail;
  }

  public boolean estaVazia(){
    return(head==null);
  }

  public Object getPrimeiro() throws ListaVaziaException{
    if(head == null){
      throw new ListaVaziaException();
    }
    return head.data;
  }

  public Object getUltimo() throws ListaVaziaException{
    if(tail == null){
      throw new ListaVaziaException();
    }
    return tail.data;
  }

  public void inserirInicio(Object item){
    Element elementoTemporario = new Element(item, head);
    if(head == null){
      tail=elementoTemporario;
    }
    head = elementoTemporario;
  }

  public void inserirFim(Object item){
    Element elementoTemporario = new Element(item, null);
    if(head == null){
      head = elementoTemporario;
    } else {
      tail.next= elementoTemporario;
    }
    tail = elementoTemporario;
  }

  public void atribuir(ListaEncadeada L){
    if(L != this){
      this.fazVazia();
      for(Element ponteiroAnteiror = L.head; ponteiroAnteiror != null; ponteiroAnteiror = ponteiroAnteiror.next){
        this.inserirFim(ponteiroAnteiror.data);
      }
    }
  }

  public void concatenarListas(ListaEncadeada L){
      for(Element ponteiroAnteiror = L.head; ponteiroAnteiror != null; ponteiroAnteiror = ponteiroAnteiror.next){
        this.inserirFim(ponteiroAnteiror.data);
      }
  }

  public void extrair(Object item) throws ObjetoNaoEncontradoException{
    Element ponteiroAnteiror = head;
    Element ant = null;
    while(ponteiroAnteiror != null && !ponteiroAnteiror.data.equals(item)){
      ant = ponteiroAnteiror;
      ponteiroAnteiror = ponteiroAnteiror.next;
    }
    if(ponteiroAnteiror == null){
      throw new ObjetoNaoEncontradoException();
    }
    if(ponteiroAnteiror == head){
      head = ponteiroAnteiror.next;
    } else {
      ant.next = ponteiroAnteiror.next;
    }
    if(ponteiroAnteiror == tail){
      tail = ant;
    }
  }

  public void imprimirLista(){
    Element ponteiroAnteiror = head;
    System.out.println("Lista " + this.getClass().getSimpleName() + ":");
    while(ponteiroAnteiror != null){
      System.out.print(ponteiroAnteiror.data + " | ");
      ponteiroAnteiror = ponteiroAnteiror.next;
    }
  }

  public void tamanhoDaLista(){
    int tamanho = 0;
    Element ponteiro = head;
    while(ponteiro != null){
      tamanho++;
      ponteiro = ponteiro.next;
    }
    System.out.println("\nTamanho da lista: " + tamanho);
  }

}