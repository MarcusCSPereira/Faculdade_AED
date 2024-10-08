public class RadixSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 1, 5, 6};
   
    radixSort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void radixSort(int[] arr) {
    int n = arr.length;
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(arr, n, exp);
    }
  }

  private static void countSort(int[] arr, int n, int exp) {
    int[] output = new int[n];
    int[] count = new int[10];
    for (int i = 0; i < n; i++) {
      count[(arr[i] / exp) % 10]++;
    }
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = output[i];
    }
  }
}
