public class Hash {
  AVL_Helio<String>[] tabelaHash;
  int m; // m deve ser primo

  @SuppressWarnings("unchecked")//Apenas para remover o warning de unchecked conversion
  public Hash(int m) {
    tabelaHash = new AVL_Helio[m];
    this.m = m;
  }

  public void inserir(String strk) {
    int entradahash = funcaohash(strk);
    if (tabelaHash[entradahash] == null) {
      tabelaHash[entradahash] = new AVL_Helio<>(strk);
    } else {
      tabelaHash[entradahash] = tabelaHash[entradahash].InsereOrdenado(strk, null);
    }
  }

  public boolean remover(String strk) {
    int entradahash = funcaohash(strk);
    if (tabelaHash[entradahash] == null) {
      System.out.println("Elemento não encontrado");
      return false;
    }else{
      tabelaHash[entradahash] = tabelaHash[entradahash].removerNode(strk, null);
      return true;
    }
  }

  public void alterarValor(String strKVelho, String strkNovo) {
    if (this.remover(strKVelho)) {
      this.inserir(strkNovo);
    }
  }

  private int funcaohash(String chave) {
    int soma = 0;
    int comp = chave.length();
    for (int i = 0; i < comp; i++) {
      soma += (chave.charAt(i) * (i + 1));
    }
    return (soma % m);
  }

  public void imprimir() {
    for (int i = 0; i < m; i++) {
      if (tabelaHash[i] != null) {
        System.out.print("Índice " + i + ": ");
        imprimirArvore(tabelaHash[i]);
        System.out.println();
      }
    }
  }

  private void imprimirArvore(AVL_Helio<String> node) {
    if (node != null) {
      imprimirArvore(node.getFilho_esq());
      System.out.print(node.getValor() + " ");
      imprimirArvore(node.getFilho_dir());
    }
  }
}
