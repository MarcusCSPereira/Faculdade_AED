public class BuubleSort {

  public static void main(String[] args) {

    int quantidade = 100000;
    int[] arr = new int[quantidade];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*quantidade);
    }
       
    bubbleSort(arr);

    }

  @SuppressWarnings("unused")
  private static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  private static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j);
        }
      }
    }
  }

  private static void swap(int[] arr, int j) {
    int temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
  }

  @SuppressWarnings("unused")
  private static int binarySearch(int[] arr, int x) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == x) {
        return mid;
      }
      if (arr[mid] < x) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

}