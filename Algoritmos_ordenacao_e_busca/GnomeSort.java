public class GnomeSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 1, 5, 6};

    gnomeSort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void gnomeSort(int[] arr) {
    int n = arr.length;
    int index = 0;
    while (index < n) {
      if (index == 0) {
        index++;
      }
      if (arr[index] >= arr[index - 1]) {
        index++;
      } else {
        int temp = arr[index];
        arr[index] = arr[index - 1];
        arr[index - 1] = temp;
        index--;
      }
    }
  }
}
