public class Teste {
  public static void main(String[] args) {
    
    int quantidade = 10;
    int[] arrBubble = new int[quantidade];
    int[] arrHeap = new int[quantidade];
    int[] arrCount = new int[quantidade];
    int[] arrQuick = new int[quantidade];
    int[] arrRadix = new int[quantidade];
    int[] arrShell = new int[quantidade];
    int[] arrMerge = new int[quantidade];
    int[] arrGnome = new int[quantidade];

    for (int i = 0; i < arrBubble.length; i++) {
      arrBubble[i] = (int) (Math.random() * quantidade);
      arrHeap[i] = arrBubble[i];
      arrCount[i] = arrBubble[i];
      arrQuick[i] = arrBubble[i];
      arrRadix[i] = arrBubble[i];
      arrShell[i] = arrBubble[i];
      arrMerge[i] = arrBubble[i];
      arrGnome[i] = arrBubble[i];
    }

    long tempoInicial, tempoFinal;

    //BubbleSort
    tempoInicial = System.currentTimeMillis();
    bubbleSort(arrBubble);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado bubbleSort em = " + (tempoFinal - tempoInicial) + " ms"); 

    // HeapSort
    tempoInicial = System.currentTimeMillis();
    heapSort(arrHeap);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado heapSort em = " + (tempoFinal - tempoInicial) + " ms");

    // CountingSort
    tempoInicial = System.currentTimeMillis();
    countingSort(arrCount);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado countingSort em = " + (tempoFinal - tempoInicial) + " ms");

    // QuickSort
    tempoInicial = System.currentTimeMillis();
    quickSort(arrQuick, 0, arrQuick.length - 1);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado quickSort em = " + (tempoFinal - tempoInicial) + " ms");

    // RadixSort
    tempoInicial = System.currentTimeMillis();
    radixSort(arrRadix);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado radixSort em = " + (tempoFinal - tempoInicial) + " ms");

    // ShellSort
    tempoInicial = System.currentTimeMillis();
    shellSort(arrShell);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado shellSort em = " + (tempoFinal - tempoInicial) + " ms");

    // MergeSort
    tempoInicial = System.currentTimeMillis();
    mergeSort(arrMerge, 0, arrMerge.length - 1);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado mergeSort em = " + (tempoFinal - tempoInicial) + " ms");

    // GnomeSort
    tempoInicial = System.currentTimeMillis();
    gnomeSort(arrGnome);
    tempoFinal = System.currentTimeMillis();
    System.out.println("\nExecutado gnomeSort em = " + (tempoFinal - tempoInicial) + " ms");
  }

  // BubbleSort
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

  // GnomeSort
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

  // ShellSort
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

  // RadixSort
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

  // QuickSort
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

  // HeapSort
  private static void heapSort(int[] arr) {
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }
    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
    }
  }
  private static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      heapify(arr, n, largest);
    }
  }

  // CountingSort
  private static void countingSort(int[] arr) {
    int n = arr.length;
    int[] output = new int[n];
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    int[] count = new int[max + 1];
    for (int i = 0; i < n; i++) {
      count[arr[i]]++;
    }
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      output[count[arr[i]] - 1] = arr[i];
      count[arr[i]]--;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = output[i];
    }
  }

  // MergeSort
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
