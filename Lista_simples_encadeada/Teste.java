public class Teste {
  public static void main(String[] args) throws ListaVaziaException, ObjetoNaoEncontradoException {
    
    ListaEncadeada l1 = new ListaEncadeada();
    ListaEncadeada l2 = new ListaEncadeada();

    String[] strings = {"Caminhão", "Carro", "Casa", "Apartamento"};
    int[] inteiros = {1, 2, 3, 4};

    l1.inserirInicio(strings[0]);//inserindo no inicio a string caminhao
    l1.inserirInicio(strings[1]);//inserindo no inico a string carro , antes de caminhao 
    l1.inserirFim(inteiros[0]);//insere no fim o numero 1, depois de caminhao
    l1.extrair(strings[1]);//remove carro da lista

    l2.inserirFim(inteiros[1]);//inserindo no fim o numero 2 na lista l2
    l2.inserirFim(strings[2]);//insere no fim a string casa na lista l2
    l2.inserirInicio(inteiros[2]);//inserindo no incio o numero 3 na lista l2

    l1.concatenarListas(l2);//concatenando l2 na l1

    l1.extrair(inteiros[1]);//tirando o numero 2 da lista 1 que agora possui as antigas l1 e l2

    l1.imprimirLista();//imprimindo a lista
    l1.tamanhoDaLista();//tamanho da lista
  }
}
