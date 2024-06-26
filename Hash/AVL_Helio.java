public class AVL_Helio<T extends Comparable<T>> extends Node<T> {
  /*
   * A classe Node AVL herda de Node.
   * É adicionado nessa classe o fato de balancamento.
   */
  private int fatorbalanceamento = 0;

  public AVL_Helio(T v) {
    super(v);
    fatorbalanceamento = 0;
  }

  // o metodo getfilho é reescrito para retornar um node AVL
  public AVL_Helio<T> getFilho_dir() {

    return (AVL_Helio<T>) super.getFilho_dir();
  }

  // o metodo getfilho é reescrito para retornar um node AVL
  public AVL_Helio<T> getFilho_esq() {
    return (AVL_Helio<T>) super.getFilho_esq();
  }

  // fator de balanceamento de cada no AVL
  public int getFB() {
    // this.fatorbalanceamento = calculaFatorBalanceamento();
    return this.fatorbalanceamento;
  }

  // reescreveremos o metodo inserir para atualizar o fator de balanceamento apos
  // a insercao
  protected AVL_Helio<T> InsereOrdenado(T v, AVL_Helio<T> nodepai) {
    AVL_Helio<T> resultado;

    if (v.toString().compareTo(this.getValor().toString()) < 0) {
      // o valor deve ser inserido a esquerda do no atual
      if (this.getFilho_esq() != null) {
        this.getFilho_esq().InsereOrdenado(v, this);// senao for nulo continua navegando na arvore ate encontrar uma
                                                    // folha
        resultado = this.verificarbalanceamento(nodepai);// verifica balanceamento e rotaciona se necessario retornando
                                                         // a nova raiz.

        return resultado;
      } else {
        AVL_Helio<T> n = new AVL_Helio<T>(v);// se for nulo, cria o no e adiciona na folha
        this.setEsq(n);
      }
    }

    else {
      // o valor deve ser inserido a direita atual
      if (this.getFilho_dir() != null) {
        this.getFilho_dir().InsereOrdenado(v, this);
        resultado = this.verificarbalanceamento(nodepai);// verifica e o balanceamento e rotaciona se necessario
                                                         // retornando a nova raiz da rotacao
        return resultado;
      } else {
        AVL_Helio<T> n = new AVL_Helio<T>(v);
        this.setDir(n);
      }

    }
    return this;// retorna a raiz do no criado
  }

  /*
  protected AVL_Helio<T> removerNode(T v, AVL_Helio<T> nodepai) {
    int comparacao = v.compareTo(this.getValor());
    AVL_Helio<T> resultado = this;
    if (comparacao < 0) {
      if (this.getFilho_esq() != null) {
        this.getFilho_esq().removerNode(v, this);
        resultado = this.verificarbalanceamento(nodepai);
        System.out.println("Entrei aqui 1");
        return resultado;
      } else
        System.out.println("Entrei aqui 2");
        return resultado;
    } else if (comparacao > 0) {
      if (this.getFilho_dir() != null) {
        this.getFilho_dir().removerNode(v, this);
        resultado = this.verificarbalanceamento(nodepai);
        System.out.println("Entrei aqui 3");
        return resultado;
      } else
        System.out.println("Entrei aqui 4");
        return resultado;
    } else {
      if ((this.getFilho_esq() == null) && (this.getFilho_dir() == null)) {
        this.setFilhoNode(nodepai, null);
        System.out.println("Entrei aqui 5");
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() == null)) {
        this.setFilhoNode(nodepai, this.getFilho_esq());
        System.out.println("Entrei aqui 6");
      } else if ((this.getFilho_esq() == null) && (this.getFilho_dir() != null)) {
        this.setFilhoNode(nodepai, this.getFilho_dir());
        System.out.println("Entrei aqui 7");
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() != null)) {
        Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor();
        Node<T> paiMenorNodeDir;
        System.out.println("Entrei aqui 8");
        if (menorNodeDir != this.getFilho_dir()) {
          paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
          System.out.println("Entrei aqui 9");
        } else
          paiMenorNodeDir = this;
        this.setValor(menorNodeDir.getValor());
        menorNodeDir.setFilhoNode(paiMenorNodeDir, menorNodeDir.getFilho_dir());
        System.out.println("Entrei aqui 10");
      }
    }
    System.out.println("Entrei aqui 11");
    return resultado;
  }
  */
  
  
protected AVL_Helio<T> removerNode(T v, AVL_Helio<T> nodepai) {
  // Se o valor a ser removido é menor que o valor do nó atual
  if (v.compareTo(this.getValor()) < 0) {
    // Se o filho à esquerda não é nulo
    if (this.getFilho_esq() != null) {
      // Remover o valor do filho à esquerda
      this.setEsq(this.getFilho_esq().removerNode(v, this));
    }
  // Se o valor a ser removido é maior que o valor do nó atual
  } else if (v.compareTo(this.getValor()) > 0) {
    // Se o filho à direita não é nulo
    if (this.getFilho_dir() != null) {
      // Remover o valor do filho à direita
      this.setDir(this.getFilho_dir().removerNode(v, this));
    }
  // Se encontramos o nó a ser removido (valores são iguais)
  } else {
    // Caso o nó tenha apenas um filho ou nenhum
    if (this.getFilho_esq() == null || this.getFilho_dir() == null) {
      // Retorna o filho que não é nulo, ou nulo se ambos forem nulos
      return (this.getFilho_esq() != null) ? this.getFilho_esq() : this.getFilho_dir();
    } else {
      // Caso o nó tenha dois filhos
      // Encontra o menor valor do filho à direita (o sucessor in-order)
      Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor();
      // Substitui o valor do nó atual pelo menor valor do filho à direita
      this.setValor(menorNodeDir.getValor());
      // Remove o menor valor do filho à direita
      this.setDir(this.getFilho_dir().removerNode(this.getValor(), this));
    }
  }
  // Após remoção, verifica e corrige o balanceamento da árvore
  return this.verificarbalanceamento(nodepai);
}

  


  public AVL_Helio<T> acharPai(Node<T> noraiz) {
    return (AVL_Helio<T>) super.acharPai(noraiz);
  }

  // calcular fator balanceamento node
  private int calculaFatorBalanceamento() {
    int alturaesq = 0;
    int alturadir = 0;
    if (this.getFilho_esq() != null)
      alturaesq = this.getFilho_esq().calculaAltura() + 1;
    if (this.getFilho_dir() != null)
      alturadir = this.getFilho_dir().calculaAltura() + 1;
    this.fatorbalanceamento = alturadir - alturaesq;
    return this.fatorbalanceamento;
  }

  private AVL_Helio<T> verificarbalanceamento(AVL_Helio<T> nopai) {

    int fb = this.calculaFatorBalanceamento();
    int fb1 = 0;
    if ((fb < -1) || (fb > 1)) {// verificar se ha desbalanceamento.
      if (fb > 1) { // o lado direito é bem maior
        if (this.getFilho_dir() != null) {
          fb1 = this.getFilho_dir().calculaFatorBalanceamento();
          if (fb1 < 0)
            return this.rotacaoDuplaAEsquerda(nopai);
          else
            return this.rotacaoAEsquerda(nopai);
        }

      } else { // fb<-1
        fb1 = 0;
        if (this.getFilho_esq() != null)
          fb1 = this.getFilho_esq().calculaFatorBalanceamento();
        if (fb1 > 0)
          return this.rotacaoDuplaADireita(nopai);
        else
          return this.rotacaoADireita(nopai);
      }
    }
    return this;
  }

  // implementamos o algoritmo para rotacao a esquerda
  private AVL_Helio<T> rotacaoAEsquerda(AVL_Helio<T> nopaideA) {
    AVL_Helio<T> novaraizB = this.getFilho_dir();// filho da direita sera a nova raiz
    AVL_Helio<T> tempA = this;// raiz da rotacao
    if (novaraizB != null) {
      this.setFilhoNode(nopaideA, novaraizB);// filho da direita da antiga raiz vira a nova raiz
      tempA.setDir(novaraizB.getFilho_esq());// filho da esquerda da nova raiz vira filho da direita da antiga raiz
      novaraizB.setEsq(tempA);// antiga raiz vira filho da esquerda da nova raiz
    }
    // if f
    return novaraizB;
  }

  // implementamos o algoritmo para rotacao a direita
  private AVL_Helio<T> rotacaoADireita(AVL_Helio<T> nopaideC) {
    AVL_Helio<T> novaraizB = this.getFilho_esq();// filho da esquerda sera a nova raiz
    AVL_Helio<T> tempC = this;// raiz da rotacao
    if (novaraizB != null) {
      // nopaideC.setFilhoNode(this, novaraizB);//o filho da direita vira a raiz
      this.setFilhoNode(nopaideC, novaraizB);//// o filho da direita vira a raiz
      tempC.setEsq(novaraizB.getFilho_dir());// filho da direita da nova raiz vira filho da Esquerda da antiga raiz
      novaraizB.setDir(tempC);// antiga raiz vira filho da direita da nova raiz
    }
    // if f
    return novaraizB;
  }

  // rotação dupla é a chamada consecutiva de duas rotacoes simples
  private AVL_Helio<T> rotacaoDuplaAEsquerda(AVL_Helio<T> nopaideA) {
    // rotacao simples a direita no filho da direita.
    this.getFilho_dir().rotacaoADireita(this);
    // rotacao a esquerda na arvore original
    return this.rotacaoAEsquerda(nopaideA);
  }

  // rotação dupla é a chamada consecutiva de duas rotacoes simples
  private AVL_Helio<T> rotacaoDuplaADireita(AVL_Helio<T> nopaideA) {
    // rotacao simples a esquerda no filho da esquerda
    this.getFilho_esq().rotacaoAEsquerda(this);
    // rotacao a esquerda na arvore original
    return this.rotacaoADireita(nopaideA);
  }

  public String StringK() {
    StringBuilder sb = new StringBuilder();
    construirString(this, sb);
    return sb.toString();
  }

  private void construirString(AVL_Helio<T> node, StringBuilder sb) {
    if (node != null) {
      construirString(node.getFilho_esq(), sb);
      sb.append(node.getValor()).append(" -> ");
      construirString(node.getFilho_dir(), sb);
    }
  }

}