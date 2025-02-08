public class SearchAlgorithms {
    // Búsqueda secuencial
    public static int sequentialSearch(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    // Búsqueda binaria (requiere que el arreglo esté ordenado)
    public static int binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // No encontrado
    }
}

