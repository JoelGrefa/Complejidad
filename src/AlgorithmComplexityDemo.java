
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class AlgorithmComplexityDemo {

    public static void main(String[] args) {
        // Generar un arreglo de 1 millón de elementos con valores aleatorios
        int size = 1000000;
        int[] array = generateRandomArray(size);
        
        // Medir la solución genérica
        long startTime = System.nanoTime();
        long sumGeneric = sumGeneric(array);
        long endTime = System.nanoTime();
        long elapsedTimeGeneric = endTime - startTime;
        long memoryUsageGeneric = getMemoryUsage(array);

        System.out.println("Solución Genérica:");
        System.out.println("Suma: " + sumGeneric);
        System.out.println("Tiempo de ejecución: " + elapsedTimeGeneric + " nanosegundos");
        System.out.println("Uso de memoria: " + memoryUsageGeneric + " bytes");

        // Medir la solución optimizada
        startTime = System.nanoTime();
        long sumOptimized = sumOptimized(array);
        endTime = System.nanoTime();
        long elapsedTimeOptimized = endTime - startTime;
        long memoryUsageOptimized = getMemoryUsage(array);

        System.out.println("\nSolución Optimizada:");
        System.out.println("Suma: " + sumOptimized);
        System.out.println("Tiempo de ejecución: " + elapsedTimeOptimized + " nanosegundos");
        System.out.println("Uso de memoria: " + memoryUsageOptimized + " bytes");
    }

    // Solución Genérica: Iterar sobre todos los elementos y sumar uno por uno
    public static long sumGeneric(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    // Solución Optimizada: Evitar recorrer el arreglo varias veces
    public static long sumOptimized(int[] array) {
        long sum = 0;
        long[] prefixSum = new long[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
        sum = prefixSum[array.length - 1];
        return sum;
    }

    // Método para generar un arreglo de tamaño n con números aleatorios
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);  // Números aleatorios entre 0 y 99
        }
        return array;
    }

    // Método para obtener el uso de memoria en bytes de un arreglo
    public static long getMemoryUsage(int[] array) {
        return array.length * Integer.BYTES;  // El tamaño de un entero en bytes
    }
}
