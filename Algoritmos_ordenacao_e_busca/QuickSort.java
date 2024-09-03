public class QuickSort{
  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 1, 5, 6};

    quickSort(arr, 0, arr.length - 1);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void quickSort(int[] arr, int i, int j) {
    if (i < j) {
      int pivot = partition(arr, i, j);
      quickSort(arr, i, pivot - 1);
      quickSort(arr, pivot + 1, j);
    }
  }

  private static int partition(int[] arr, int i, int j) {
    int pivot = arr[i];
    int left = i;
    int right = j;
    while (left < right) {
      while (arr[left] <= pivot && left < right) {
        left++;
      }
      while (arr[right] > pivot) {
        right--;
      }
      if (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
    }
    arr[i] = arr[right];
    arr[right] = pivot;
    return right;
  }

  
}