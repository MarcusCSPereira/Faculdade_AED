public class Franco {

  public static void main(String[] args) {
    int vetor[] = { 13 , 22 , 17 , -20 , -2 , 33 , 56 , 112 , 57 , 99};
    imprimeVetor(vetor);
    ordenar(vetor);
    System.out.println();
    imprimeVetor(vetor);
  }

  public static void ordenar(int vetor[]){
    int N = vetor.length;

    for(int i = N/2-1 ; i >=0 ; i--){
      heapyfi(vetor, N, i);
    }

    for(int i =N-1 ; i >0 ; i--){
      int temp = vetor[0];
      vetor[0] = vetor[i];
      vetor[i] = temp;
      heapyfi(vetor, i, 0);
    }
  }

  public static void heapyfi(int vetor[], int tamanhoVetor , int i){
    int raiz = i;
    int esquerda = 2*i +1;
    int direita = 2*i +2;
   
    if(esquerda < tamanhoVetor && vetor[esquerda]> vetor[raiz]){
      raiz = esquerda;
    }
    if(direita < tamanhoVetor && vetor[direita] > vetor[raiz]){
      raiz = direita;
    }
    if(raiz != i){
      int temp = vetor[i];
      vetor[i] = vetor[raiz];
      vetor[raiz] = temp;
      heapyfi(vetor, tamanhoVetor, raiz);
    }

  }
  
  public static void imprimeVetor(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }
}