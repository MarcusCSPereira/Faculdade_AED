import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVL<T> {
  /*
   * A classe AVL AVL herda de AVL.
   * É adicionado nessa classe o fato de balancamento.
   */
  private int fatorbalanceamento = 0;
  T valor;
  AVL<T> filho_esq, filho_dir;
  AVL<T> raiz;

  @SuppressWarnings("unused")
  private AVL<T> pai;

  public AVL(T v) {
    valor = v;
    filho_esq = null;
    filho_dir = null;
    fatorbalanceamento = 0;
    raiz = this;
  }

  public AVL<T> getFilho_esq() {
    return filho_esq;
  }

  public AVL<T> getFilho_dir() {
    return filho_dir;
  }

  public T getValor() {
    return valor;
  }

  public void setValor(T v) {
    valor = v;
  }

  public void setEsq(AVL<T> n) {
    filho_esq = n;
  }

  public void setDir(AVL<T> n) {
    filho_dir = n;
  }

  // fator de balanceamento de cada no AVL
  public int getFB() {
    return this.fatorbalanceamento;
  }

  // reescreveremos o metodo inserir para atualizar o fator de balanceamento apos a insercao
  protected boolean InsereOrdenado(T v, AVL<T> AVLpai) {
    boolean resultado;

    if (v.toString().compareTo(this.getValor().toString()) < 0) {
      // o valor deve ser inserido a esquerda do no atual
      if (this.getFilho_esq() != null) {
        resultado = this.getFilho_esq().InsereOrdenado(v, this);// senao for nulo continua navegando na arvore ate encontrar uma folha
        AVLpai = raiz.acharPai(this.filho_esq);// achar o pai do no atual (AVLpai)
        this.verificarbalanceamento(AVLpai);// verifica balanceamento e rotaciona se necessario.
        return resultado;
      } else {
        AVL<T> n = new AVL<T>(v);
        this.setEsq(n);
        AVLpai = raiz.acharPai(this.filho_esq);// achar o pai do no atual (AVLpai)
        return true;
      }
    }

    else {
      // o valor deve ser inserido a direita atual
      if (this.getFilho_dir() != null) {
        resultado = this.getFilho_dir().InsereOrdenado(v, this);
        AVLpai = raiz.acharPai(this.filho_dir);// achar o pai do no atual (AVLpai)
        this.verificarbalanceamento(AVLpai);// verifica e o balanceamento e rotaciona se necessario
        return resultado;
      } else {
        AVL<T> n = new AVL<T>(v);
        this.setDir(n);
        AVLpai = raiz.acharPai(this.filho_dir);// achar o pai do no atual (AVLpai)
        return true;
      }

    }

  }

  protected boolean removerAVL(T v, AVL<T> AVLpai) {

    int comparacao = v.toString().compareTo(this.getValor().toString());
    boolean resultado = false;

    if (comparacao < 0) {
      if (this.getFilho_esq() != null) {
        resultado = this.getFilho_esq().removerAVL(v, this); // o nó a ser removido ta na subarvore esquerda
        this.verificarbalanceamento(AVLpai);// verifica balanceamento e rotaciona se necessario.
        return resultado;
      } else
        resultado = false;// o valor nao ta na subarvoreesquerda
    } else if (comparacao > 0) {
      if (this.getFilho_dir() != null) {
        resultado = this.getFilho_dir().removerAVL(v, this); // o valor pode estah na subarvore direita
        this.verificarbalanceamento(AVLpai);// verifica balanceamento e rotaciona se necessario.
        return resultado;
      } else
        resultado = false;// valor nao foi encontrado }
    } else // o no a ser removido é o atual.
    {
      if ((this.getFilho_esq() == null) && (this.getFilho_dir() == null)) {
        // este AVL é folha, pois os dois filhos sao nulos
        this.setFilhoAVL(AVLpai, null);// setar o filho de pai como nulo
        resultado = true;
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() == null)) {
        // o AVL tem o filho da esquerda diferente de nulo e o da direita eh nulo
        this.setFilhoAVL(AVLpai, this.getFilho_esq()); // seta o pai o AVL atual com o filho da esquerda do AVLatual
        resultado = true;
      } else if ((this.getFilho_esq() == null) && (this.getFilho_dir() != null)) {
        // o AVL tem o filho da direita diferente de nulo e o da esquerda eh nulo
        this.setFilhoAVL(AVLpai, this.getFilho_dir()); // seta o pai do AVL atual com o filho da direita do AVLatual
        resultado = true;
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() != null)) {
        // podemos pegar um dos dois AVLs a seguir, tanto faz.
        // AVL<String> nEsq = AVLComMaiorValor(AVLatual.getFilho_esq()); //pega o
        // AVL com maior valor da subarvore esquerda

        AVL<T> menorAVLDir = this.getFilho_dir().AVLComMenorValor(); // pega o AVL com menor valor da subarvore da
                                                                     // direita
        AVL<T> paiMenorAVLDir;
        if (menorAVLDir != this.getFilho_dir()) {
          paiMenorAVLDir = this.getFilho_dir().acharPai(menorAVLDir);
        } else
          paiMenorAVLDir = this;

        this.setValor(menorAVLDir.getValor());// coloca o novo valor no AVLatual.
        /*
         * Se menorAVLDir eh o menor valor da subarvore direita, entao menorAVLDir nao
         * tem filhos a esquerda porque
         * o menor valor de uma arvore eh o AVL mais a esquerda dessa arvore
         * sendo assim, eu já sei que o menorAVLDir tem no maximo um filho a direita
         * ou ele eh um AVL folha.
         * Sendo assim posso setar diretamente o filho (direita) do paiMenorNoDir com o
         * filho da direita do menorAVLDir
         */
        menorAVLDir.setFilhoAVL(paiMenorAVLDir, menorAVLDir.getFilho_dir()); // seta o pai do menorAVL com o filho
                                                                             // da direita
        resultado = true;
      }

    }

    return resultado;
  }

  protected AVL<T> AVLComMaiorValor() {
    if (this.getFilho_dir() != null) {
      return this.getFilho_dir().AVLComMaiorValor();
    } else
      return this;
  }// fim algotimo

  protected AVL<T> AVLComMenorValor() {
    if (this.getFilho_esq() != null) {
      return this.getFilho_esq().AVLComMenorValor();
    } else
      return this;
  }// fim algotimo

  protected void setFilhoAVL(AVL<T> AVLPai, AVL<T> novoAVL) {

    if (AVLPai.getFilho_esq() == this) {
      AVLPai.setEsq(novoAVL);
    } else if (AVLPai.getFilho_dir() == this) {
      AVLPai.setDir(novoAVL);
    }
  }

  protected AVL<T> acharPai(AVL<T> nofilho) {
    /*
     * Esse algoritmo retorna o pai do AVL noFilho
     * O algoritmo verifica se o AVL do contexto de execução do metodo
     * AVL This eh pai (pela esquerda ou pela direita) do nofilho.
     */

    if (this.getFilho_esq() == nofilho || this.getFilho_dir() == nofilho) {
      return this;
    } else {
      if (nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0) { // subarvore esquerda
        if (this.getFilho_esq() != null) {
          return this.getFilho_esq().acharPai(nofilho);
        } else {
          return null;// pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
        }
      } else {// subarvore direita
        if (this.getFilho_dir() != null) {
          return this.getFilho_dir().acharPai(nofilho);
        } else {
          return null; // pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
        }
      }
    }
  }

  protected int calculaAltura() {
    // comprimento do caminho mais longo do nó a uma folha.
    int alturaesquerda = 0;
    int alturadireita = 0;

    if (this.getFilho_esq() != null)
      alturaesquerda = this.getFilho_esq().calculaAltura() + 1;

    // aqui, como vou saber a altura do filho da direita pra eu poder calcular a
    // altura do AVL

    if (this.getFilho_dir() != null)
      alturadireita = this.getFilho_dir().calculaAltura() + 1;

    if (alturaesquerda > alturadireita)
      return alturaesquerda;

    else
      return alturadireita;
  }

  // calcular fator balanceamento AVL
  private int calculaFatorBalanceamento() {
    int alturaesq = 0;
    int alturadir = 0;
    if (this.getFilho_esq() != null)
      alturaesq = this.getFilho_esq().calculaAltura();
    if (this.getFilho_dir() != null)
      alturadir = this.getFilho_dir().calculaAltura();
    this.fatorbalanceamento = alturadir - alturaesq;
    return this.fatorbalanceamento;
  }

  private void verificarbalanceamento(AVL<T> nopai) {

    int fb = this.calculaFatorBalanceamento();
    int fb1 = 0;
    if ((fb < -1) || (fb > 1)) {// verificar se ha desbalanceamento.
      if (fb > 1) { // o lado direito é bem maior
        if (this.getFilho_dir() != null) {
          fb1 = this.getFilho_dir().calculaFatorBalanceamento();
          if (fb1 < 0)
            this.rotacaoDuplaAEsquerda(nopai);
          else
            this.rotacaoAEsquerda(nopai);
        }

      } else { // fb<-1
        fb1 = 0;
        if (this.getFilho_esq() != null)
          fb1 = this.getFilho_esq().calculaFatorBalanceamento();
        if (fb1 > 0)
          this.rotacaoDuplaADireita(nopai);
        else
          this.rotacaoADireita(nopai);
      }
    }
  }

  protected AVL<T> pesquisarValor(T v) {

    int comparacao = v.toString().compareTo(this.getValor().toString());

    if (comparacao < 0) {// o valor a ser pesquisado estah do lado esquerdo do AVL?
      if (this.getFilho_esq() != null)
        return this.getFilho_esq().pesquisarValor(v); // o valor pode estah na arvore esquerda
      else
        return null;// valor nao foi encontrado
    } else if (comparacao > 0) {
      if (this.getFilho_dir() != null)
        return this.getFilho_dir().pesquisarValor(v); // o valor pode estah na arvore direita
      else
        return null;// valor nao foi encontrado
    } else
      return this;// o valor encontra-se nesse noh atual

  }

  protected void imprimeInOrdem() {

    if (this.getFilho_esq() != null) {
      this.getFilho_esq().imprimeInOrdem();
    }

    System.out.print(this.valor + " "); // visitando o no raiz

    if (this.getFilho_dir() != null) {
      this.getFilho_dir().imprimeInOrdem();
    }

  }

  protected void imprimeInOrdem2() {

    if (this.getFilho_dir() != null) {
      this.getFilho_dir().imprimeInOrdem2();
    }

    System.out.print(this.valor + " "); // visitando o no raiz

    if (this.getFilho_esq() != null) {
      this.getFilho_esq().imprimeInOrdem2();
    }

  }

  protected void imprimeEmPreordem() {

    System.out.print(this.valor + " "); // visitando o no raiz

    if (this.getFilho_esq() != null) {
      this.getFilho_esq().imprimeEmPreordem();
    }
    if (this.getFilho_dir() != null) {
      this.getFilho_dir().imprimeEmPreordem();
    }
  }

  protected void imprimeEmPosordem() {

    if (this.getFilho_esq() != null) {
      this.getFilho_esq().imprimeEmPosordem();
    }
    if (this.getFilho_dir() != null) {
      this.getFilho_dir().imprimeEmPosordem();
    }

    System.out.print(this.valor + " "); // visitando o no raiz

  }

  protected int calculaTotalNodes() {
    int totalesq = 0;
    int totaldir = 0;

    if (this.getFilho_esq() != null) {
      totalesq = this.getFilho_esq().calculaTotalNodes();
    }
    if (this.getFilho_dir() != null) {
      totaldir = this.getFilho_dir().calculaTotalNodes();
    }

    return totalesq + totaldir + 1;
  }

  protected int calculaTotalNodesFolhas() {

    int totalesq = 0;
    int totaldir = 0;
    boolean ehfolha = true;

    if (this.getFilho_esq() != null) {
      totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
      ehfolha = false;
    }
    if (this.getFilho_dir() != null) {
      totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
      ehfolha = false;
    }
    if (ehfolha) {
      return 1;
    } else
      return (totaldir + totalesq);
  }

  protected void imprimeEmLargura() {
    Queue<AVL<T>> f = new LinkedList<>();
    f.add(this);
    while (!f.isEmpty()) {
      AVL<T> no = (AVL<T>) f.poll();

      if (no.getFilho_esq() != null) {
        f.add(no.getFilho_esq());
        ;
      }
      if (no.getFilho_dir() != null) {
        f.add(no.getFilho_dir());
      }

      System.out.print(no.getValor() + " ");

    } // while
  }// imprimelargura

  protected void imprimeEmLarguraRecursivo(Queue<AVL<T>> f) {
    if (!f.isEmpty()) {
      AVL<T> no = (AVL<T>) f.poll();

      if (no != null) {
        if (no.getFilho_esq() != null) {
          f.add(no.getFilho_esq());
        }
        if (no.getFilho_dir() != null) {
          f.add(no.getFilho_dir());
        }
        System.out.print(no.getValor() + " ");
        this.imprimeEmLarguraRecursivo(f);
      }
    }
  }

  protected void imprimeEmLarguraInvertido() {
    Queue<AVL<T>> f = new LinkedList<>();
    Stack<String> p = new Stack<>();

    f.add(this);
    while (!f.isEmpty()) {
      AVL<T> no = (AVL<T>) f.poll();

      if (no.getFilho_esq() != null) {
        f.add(no.getFilho_esq());
        ;
      }
      if (no.getFilho_dir() != null) {
        f.add(no.getFilho_dir());
      }

      p.push(no.getValor().toString());
      // System.out.print(no.getValor()+ " ");

    } // while

    imprimePilha(p);

  }

  private void imprimePilha(Stack<String> p) {

    while (!p.empty()) {

      System.out.print(p.pop() + " ");
    }
  }

  // implementamos o algoritmo para rotacao a esquerda
  private void rotacaoAEsquerda(AVL<T> nopaideA) {
    AVL<T> novaraizB = this.getFilho_dir();// filho da direita sera a nova raiz
    AVL<T> tempA = this;// raiz da rotacao
    if (novaraizB != null) {
      nopaideA.setFilhoAVL(this, novaraizB);// o filho da direita vira a raiz
      tempA.setDir(novaraizB.getFilho_esq());// filho da esquerda da nova raiz vira filho da direita da antiga raiz
      novaraizB.setEsq(tempA);// no A vira filho da direita da nova raizB
    }
    System.out.println("Rotacao a esquerda");
    // if f
  }

  // implementamos o algoritmo para rotacao a direita
  private void rotacaoADireita(AVL<T> nopaideC) {
    AVL<T> novaraizB = this.getFilho_esq();// filho da esquerda sera a nova raiz
    AVL<T> tempC = this;// raiz da rotacao
    if (novaraizB != null) {
      nopaideC.setFilhoAVL(this, novaraizB);// o filho da direita vira a raiz
      tempC.setEsq(novaraizB.getFilho_dir());// filho da direita da nova raiz vira filho da Esquerda da antiga raiz
      novaraizB.setDir(tempC);//
    }
    System.out.println("Rotacao a direita");
    // if f
  }

  // rotação dupla é a chamada consecutiva de duas rotacoes simples
  private void rotacaoDuplaAEsquerda(AVL<T> nopaideA) {
    // rotacao simples a direita no filho da direita.
    this.getFilho_dir().rotacaoADireita(this);
    // rotacao a esquerda na arvore original
    this.rotacaoAEsquerda(nopaideA);
  }

  // rotação dupla é a chamada consecutiva de duas rotacoes simples
  private void rotacaoDuplaADireita(AVL<T> nopaideA) {
    // rotacao simples a esquerda no filho da esquerda
    this.getFilho_esq().rotacaoAEsquerda(this);
    // rotacao a esquerda na arvore original
    this.rotacaoADireita(nopaideA);
  }

}