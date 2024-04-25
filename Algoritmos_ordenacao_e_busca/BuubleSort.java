public class BuubleSort {

  public static void main(String[] args) {
    int[] arr = { 5, 2, 8, 7, 1 };
    bubbleSort(arr);
    System.out.println("Sorted array's: ");
    printArray(arr);
    int x = 7;
    int result = binarySearch(arr, x);
    if (result == -1) {
      System.out.println("Element não está presente no array");
    } else {
      System.out.println("Element encontrado no índice: " + result);
    }
  }

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
          /*
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          */
        }
      }
    }
  }

  private static void swap(int[] arr, int j) {
    int temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
  }

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