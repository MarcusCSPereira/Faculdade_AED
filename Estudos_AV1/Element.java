
public class Element<T> {

  private T data;
  private Element<T> next;

  Element(T data) {
    this.data = data;
    this.next = null;
  }

  Element(T data, Element<T> next) {
    this.data = data;
    this.next = next;
  } 

  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }

  public Element<T> getNext() {
    return next;
  }

  public void setNext(Element<T> next) {
    this.next = next;
  }

  public void inserirAntes(T data){
    Element<T> temp = new Element<T>(data);
    temp.setNext(this);
    this.next = temp;
  }

  public void inserirDepois(T data){
    Element<T> temp = new Element<T>(data);
    temp.setNext(this.next);
    this.next = temp;
  }

  @Override
  public String toString() {
    return "Data:[ " + data.toString() + " ]";
  }


}
