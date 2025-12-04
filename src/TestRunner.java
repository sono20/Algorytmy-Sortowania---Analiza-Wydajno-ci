import java.util.Scanner;

public class TestRunner {
    public static void testPredefinedArray() {
        int[] array = {64, 31, 511, 11, 24, 16, 32, 67, 85, 95, 35, 81, 53, 742, 13, 1, 7, 3, 9, 2};

        System.out.println("\n==========TEST NA TABLICY PRZYKŁADOWEJ==========");
        System.out.println("Tablica przed posortowaniem:");
        printArray(array);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("\t\tTestowanie wszystkich algorytmów:");
        System.out.println("=".repeat(50));

        for (Algorithm algorithm : Algorithm.values()) {
            int[] copy = array.clone();
            double time = Timer.measureTime(copy, algorithm);

            System.out.printf("%-20s | Czas: %8.2f ns |", algorithm.getName(), time);
            System.out.println();
        }
        System.out.println("\nTablica po posortowaniu:");
        Algorithm firstAlg = Algorithm.values()[0];
        int[] sorted = array.clone();
        firstAlg.sort(sorted);
        printArray(sorted);
    }

    public static void testConsoleArray(Scanner scanner) {
        int[] array = InputHandler.loadFromConsole(scanner);
        if (array == null) return;

        System.out.println("\nTablica przed posortowaniem:");
        printArray(array);
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\t\tTestowanie wszystkich algorytmów:");
        System.out.println("=".repeat(50));

        for (Algorithm algorithm : Algorithm.values()) {
            int[] copy = array.clone();
            double time = Timer.measureTime(copy, algorithm);

            System.out.printf("%-20s | Czas: %8.2f ns | ", algorithm.getName(), time);
            System.out.println();
        }
        System.out.println("\nTablica po posortowaniu:");
        Algorithm firstAlg = Algorithm.values()[0];
        int[] sorted = array.clone();
        firstAlg.sort(sorted);
        printArray(sorted);
    }

    public static void testFileArray(Scanner scanner) {
        System.out.println("Podaj nazwę pliku: ");
        String filename = scanner.nextLine();

        int[] array = InputHandler.loadFromFile(filename);
        if (array == null) return;

        System.out.println("Wczytano tablicę o rozmiarze: " + array.length);
        System.out.println("\nTablica przed posortowaniem:");
        printArray(array);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("\t\tTestowanie wszystkich algorytmów:");
        System.out.println("=".repeat(50));

        for (Algorithm algorithm : Algorithm.values()) {
            int[] copy = array.clone();
            double time = Timer.measureTime(copy, algorithm);

            System.out.printf("%-20s | Czas: %8.2f ns | ", algorithm.getName(), time);
            System.out.println();
        }
        System.out.println("\nTablica po posortowaniu:");
        Algorithm firstAlg = Algorithm.values()[0];
        int[] sorted = array.clone();
        firstAlg.sort(sorted);
        printArray(sorted);
    }


    public static void testScalability() {

        int[] sizes = new int[]{1000, 1500, 2000, 2500, 3000, 4000, 5000, 8000, 9000, 10000, 12500, 15000};
        Algorithm[] algorithms = Algorithm.values();


        System.out.println("\n==========TEST SKALOWALNOŚCI - PRZYPADEK ŚREDNI==========");
        System.out.println("Uśrednione z " + Timer.NUM_TRIALS + " prób");
        printScalabilityResults(sizes, algorithms, "średni");
        System.out.println("\n==========TEST SKALOWALNOŚCI - PRZYPADEK PESYMISTYCZNY==========");
        System.out.println("Uśrednione z " + Timer.NUM_TRIALS + " prób");
        printScalabilityResults(sizes, algorithms, "pesymistyczny");
    }

    private static void printScalabilityResults(int[] sizes, Algorithm[] algorithms, String caseType) {
        System.out.printf("%-12s", "Rozmiar");
        for (Algorithm alg : algorithms) {
            System.out.printf("%-24s", alg.getName());
        }
        System.out.println("\n" + "-".repeat(100));

        for (int size : sizes) {
            System.out.printf("%-12d", size);
            for (Algorithm algorithm : algorithms) {
                try {
                    double averageTime = Timer.averageTime(size, algorithm, caseType);
                    System.out.printf("%-24s",String.format("%.2f ns",averageTime));
                } catch (StackOverflowError e) {
                    System.out.printf("%-24s", "OVERFLOW");
                } catch (Exception e) {
                    System.out.printf("%-24s", "ERROR");
                }
            }
            System.out.println();
        }
    }


    private static void printArray(int[] array) {
        if (array.length <= 35) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.print("[");
            for (int i = 0; i < 10; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print("..., ");
            for (int i = array.length - 10; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[array.length - 1] + "]");
        }
    }
}