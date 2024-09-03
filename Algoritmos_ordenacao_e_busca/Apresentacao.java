import java.util.ArrayList;

public class Apresentacao {
  public static void main(String[] args) {
    ArrayList<Integer> lista = new ArrayList<Integer>();
    lista.add(1);
    inverterLista(lista);
    inverterLista2(lista);
  }

  private static void inverterLista(ArrayList<Integer> lista) {//1
    int tamanho = lista.size(); //1
    int limite = tamanho / 2; //1
    for (int i = 0; i < limite; i++) {
      int temp = lista.get(i);
      lista.set(i, lista.get(tamanho - i - 1));
      lista.set(tamanho - i - 1, temp);
    }
  }
  //Complexidade de espaço: 5 + N
  //Complexidade de tempo: 2 + 3*(N)

  private static ArrayList<Integer> inverterLista2(ArrayList<Integer> lista) {
    ArrayList<Integer> listaAux = new ArrayList<Integer>();
    int tamanho = lista.size();
    for (int i = 0; i < tamanho; i++) {
      listaAux.add(lista.get(tamanho - i - 1));
    }
    return listaAux;
  }
  // Complexidade de espaço: 
  // Complexidade de tempo: 
}
