import java.util.LinkedList;
import java.util.Queue;

public final class Node<T> {
    private T data;
    private Node<T> filhoDir,filhoEsq;

    Node(T data){
      this.data = data;
      filhoDir = null;
      filhoEsq = null;
    }

    public Node<T> getRaiz(){
      return this;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public Node<T> getFilhoDir() {
      return filhoDir;
    }

    public void setFilhoDir(Node<T> filhoDir) {
      this.filhoDir = filhoDir;
    }

    public Node<T> getFilhoEsq() {
      return filhoEsq;
    }

    public void setFilhoEsq(Node<T> filhoEsq) {
      this.filhoEsq = filhoEsq;
    }

    public boolean isLeaf(){
      return this.getFilhoDir() == null && this.getFilhoEsq() == null;
    }

    public void inserirOrdenado(T data){
      if(data.hashCode() > this.data.hashCode()){
        if(filhoDir == null){
          filhoDir = new Node<T>(data);
        }else{
          filhoDir.inserirOrdenado(data);
        }
      }else{
        if(filhoEsq == null){
          filhoEsq = new Node<T>(data);
        }else{
          filhoEsq.inserirOrdenado(data);
        }
      }
    }

    public void imprimirInOrdem(){
      if(filhoEsq != null){
        filhoEsq.imprimirInOrdem();
      }
      System.out.print(data + " | ");
      if(filhoDir != null){
        filhoDir.imprimirInOrdem();
      }
    }

    public void imprimirPreOrdem(){
      System.out.print(data + " | ");
      if(filhoEsq != null){
        filhoEsq.imprimirPreOrdem();
      }
      if(filhoDir != null){
        filhoDir.imprimirPreOrdem();
      }
    }

    public void imprimirPosOrdem(){
      if(filhoEsq != null){
        filhoEsq.imprimirPosOrdem();
      }
      if(filhoDir != null){
        filhoDir.imprimirPosOrdem();
      }
      System.out.print(data + " | ");
    }

    public void imprimirEmLargura(){
      Queue<Node<T>> fila = new LinkedList<Node<T>>();
      fila.add(this);
      while(!fila.isEmpty()){
        Node<T> no = fila.poll();
        System.out.print(no.getData() + " | ");
        if(no.getFilhoEsq() != null){
          fila.add(no.getFilhoEsq());
        }
        if(no.filhoDir != null){
          fila.add(no.getFilhoDir());
        }
      }
    }

    public Node<T> buscar(T data){
      if(data.hashCode() == this.data.hashCode()){
        return this;
      }
      if(data.hashCode() > this.data.hashCode()){
        if(filhoDir != null){
          return filhoDir.buscar(data);
        }
      }else{
        if(filhoEsq != null){
          return filhoEsq.buscar(data);
        }
      }
      return null;
    }

    // Método para remover um nó da árvore binária, não está funcionando perfeitamente, pois não remove o nó raiz corretamente e não remove o nó folha.
    public void remover(T data){
      Node<T> no = buscar(data);
      if(no != null){
        if(no.isLeaf()){
          no = null;
        }else if(no.getFilhoDir() != null && no.getFilhoEsq() != null){
          Node<T> aux = no.getFilhoDir();
          while(aux.getFilhoEsq() != null){
            aux = aux.getFilhoEsq();
          }
          no.setData(aux.getData());
          aux = null;
          no.setFilhoDir(aux);
        }else{
          if(no.getFilhoDir() != null){
            no = no.getFilhoDir();
          }else{
            no = no.getFilhoEsq();
          }
        }
      }
    }

    // Método para imprimir a árvore de forma gráfica, criado com a ajuda do Chat-GPT !
    public void imprimirArvore() {
        System.out.println("Impressão da Árvore:");

        int nivelMaximo = profundidadeMaxima(this);

        Queue<Node<T>> queue = new LinkedList<>();
        Queue<Integer> filaDeNiveis = new LinkedList<>();

        queue.add(this);
        filaDeNiveis.add(0);

        int nivelAnterior = 0;
        int espacos = (int)Math.pow(2, nivelMaximo - 1);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            Integer level = filaDeNiveis.poll();

            if(level > nivelAnterior) {
                nivelAnterior = level;
                espacos = espacos / 2;
                System.out.println();
            }

            printEspacos(espacos - 1);
            System.out.print(node.getData());
            printEspacos(espacos);

            if (node.getFilhoEsq() != null) {
                queue.add(node.getFilhoEsq());
                filaDeNiveis.add(level + 1);
            }
            if (node.getFilhoDir() != null) {
                queue.add(node.getFilhoDir());
                filaDeNiveis.add(level + 1);
            }
        }
        System.out.println("\n");
    }

    private void printEspacos(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int profundidadeMaxima(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(profundidadeMaxima(node.getFilhoEsq()), profundidadeMaxima(node.getFilhoDir()));
        }
    }
}