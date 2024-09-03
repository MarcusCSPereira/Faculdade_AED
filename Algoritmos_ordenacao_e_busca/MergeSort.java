public class MergeSort {
  public static void main(String[] args) {
    int quantidade = 100000;
    int[] arr = new int[quantidade];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * quantidade);
    }

    mergeSort(arr, 0, arr.length - 1);

    /*for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }*/
  }

  private static void mergeSort(int[] arr, int i, int j) {
    if (i < j) {
      int m = (i + j) / 2;
      mergeSort(arr, i, m);
      mergeSort(arr, m + 1, j);
      merge(arr, i, m, j);
    }
  }

  private static void merge(int[] arr, int i, int m, int j) {
    int n1 = m - i + 1;
    int n2 = j - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int x = 0; x < n1; x++) {
      L[x] = arr[i + x];
    }
    for (int y = 0; y < n2; y++) {
      R[y] = arr[m + 1 + y];
    }
    int x = 0, y = 0;
    int k = i;
    while (x < n1 && y < n2) {
      if (L[x] <= R[y]) {
        arr[k] = L[x];
        x++;
      } else {
        arr[k] = R[y];
        y++;
      }
      k++;
    }
    while (x < n1) {
      arr[k] = L[x];
      x++;
      k++;
    }
    while (y < n2) {
      arr[k] = R[y];
      y++;
      k++;
    }
  }
}
