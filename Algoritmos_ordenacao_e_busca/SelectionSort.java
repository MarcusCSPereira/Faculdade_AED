public class SelectionSort {
  public static void main(String[] args) {
    int tamanho = 10000;
    int[] arr = new int[tamanho];

    for(int i=0; i<tamanho; i++) {
      arr[i] = (int) (Math.random() * tamanho);
    }

    selectionSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void selectionSort(int[] arr) {
    int tamanho = arr.length;
    for (int i = 0; i < tamanho - 1; i++) {
      int min = i;
      for (int j = i + 1; j < tamanho; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      int temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;
    }
  }
}
