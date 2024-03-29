public class Teste {
  public static void main(String[] args) {

    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

    try {
      lista.inserirInicio(1);
      lista.inserirInicio(2);
      lista.inserirInicio(3);
      lista.inserirInicio(4);
      lista.inserirInicio(5);
      lista.inserirFim(6);
      lista.inserirFim(7);
      lista.inserirFim(8);
      lista.inserirFim(9);
      lista.inserirFim(10);
      lista.imprimir();
      lista.getTamanho();
      lista.remover(5);
      lista.remover(10);
      lista.imprimir();
      lista.getTamanho();
    } catch (ObjetoNaoEncontradoException e) {
      System.out.println(e.getMessage());
    } catch (ListaVaziaException e) {
      System.out.println(e.getMessage());
    }

  }
}
