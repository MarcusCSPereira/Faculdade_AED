public class ShellSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 1, 5, 6};

    shellSort(arr);

    // Imprime o array ordenado
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }

  private static void shellSort(int[] arr) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int temp = arr[i];
        int j;
        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
          arr[j] = arr[j - gap];
        }
        arr[j] = temp;
      }
    }
  }
}
