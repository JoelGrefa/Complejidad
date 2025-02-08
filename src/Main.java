import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			int size = 1000;
			int[][] matrix = new int[size][size];

			// Generar la matriz con números aleatorios
			MatrixUtils.fillMatrixWithRandomValues(matrix);
			int[] flatMatrix = MatrixUtils.flattenMatrix(matrix);

			// Solicitar el número a buscar
			System.out.print("Introduce el número a buscar: ");
			int x = scanner.nextInt();

			// Medir el tiempo para la solución genérica
			long startTime = System.nanoTime();
			int indexSeq = SearchAlgorithms.sequentialSearch(flatMatrix, x);
			long endTime = System.nanoTime();
			long durationSeq = endTime - startTime;

			// Medir el tiempo para la solución optimizada
			startTime = System.nanoTime();
			int indexBin = SearchAlgorithms.binarySearch(flatMatrix, x);
			endTime = System.nanoTime();
			long durationBin = endTime - startTime;

			// Mostrar los resultados de búsqueda
			System.out.println("Índice de " + x + " en búsqueda secuencial: " + indexSeq);
			System.out.println("Índice de " + x + " en búsqueda binaria: " + indexBin);
			System.out.println("Tiempo de ejecución (secuencial): " + durationSeq + " nanosegundos");
			System.out.println("Tiempo de ejecución (binaria): " + durationBin + " nanosegundos");

			// Medir la suma de los elementos
			startTime = System.nanoTime();
			int sum = MatrixUtils.calculateSum(matrix);
			endTime = System.nanoTime();
			long durationSum = endTime - startTime;

			// Mostrar la suma
			System.out.println("Suma de los elementos de la matriz: " + sum);
			System.out.println("Tiempo para calcular la suma: " + durationSum + " nanosegundos");

			// Menú para elegir el algoritmo de ordenación
			System.out.println("¿Qué algoritmo de ordenación deseas usar?");
			System.out.println("1. Bubble Sort");
			System.out.println("2. Insertion Sort");
			System.out.println("3. Merge Sort");
			System.out.println("4. Shell Sort");
			System.out.println("5. Counting Sort");
			System.out.println("6. Radix Sort");
			System.out.print("Introduce el número del algoritmo (1-6): ");
			int algorithmChoice = scanner.nextInt();

			// Ordenar la matriz según la elección
			switch (algorithmChoice) {
			    case 1:
			        SortingAlgorithms.bubbleSort(flatMatrix);
			        break;
			    case 2:
			        SortingAlgorithms.insertionSort(flatMatrix);
			        break;
			    case 3:
			        SortingAlgorithms.mergeSort(flatMatrix);
			        break;
			    case 4:
			        SortingAlgorithms.shellSort(flatMatrix);
			        break;
			    case 5:
			        SortingAlgorithms.countingSort(flatMatrix);
			        break;
			    case 6:
			        SortingAlgorithms.radixSort(flatMatrix);
			        break;
			    default:
			        System.out.println("Opción no válida");
			        return;
			}

			// Mostrar la matriz ordenada
			System.out.println("Matriz ordenada con " + getAlgorithmName(algorithmChoice));
			System.out.println("Primeros 10 elementos de la matriz ordenada:");
			for (int i = 0; i < 10; i++) {
			    System.out.print(flatMatrix[i] + " ");
			}
		}
        System.out.println();
    }

    private static String getAlgorithmName(int choice) {
        switch (choice) {
            case 1: return "Bubble Sort";
            case 2: return "Insertion Sort";
            case 3: return "Merge Sort";
            case 4: return "Shell Sort";
            case 5: return "Counting Sort";
            case 6: return "Radix Sort";
            default: return "Desconocido";
        }
    }
}

