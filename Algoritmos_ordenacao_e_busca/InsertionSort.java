public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = {1, 4, 3, 2, 8, 7, 6, 5, 4, 2, 3, 1, 9, 10};
    insertionSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void insertionSort(int[] arr) {
    int tamanho = arr.length;
    for (int i = 1; i < tamanho; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }
}
