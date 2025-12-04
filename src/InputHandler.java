import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputHandler {
    public static int[] loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Plik jest pusty!");
                return null;
            }
            String[] numbers = line.trim().split("\\s+");
            int[] array = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }
            return array;
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
            return null;
        } catch (NumberFormatException e){
            System.out.println("Błąd: Plik zawiera nieprawidłowe dane");
            return null;
        }
    }

    public static int[] loadFromConsole(Scanner scanner) {
        try {
            System.out.println("Podaj rozmiar tablicy");
            int size = scanner.nextInt();

            if (size <= 0){
                System.out.println("Rozmiar musi być większy od 0.");
                return null;
            }
            int[] array = new int[size];
            System.out.println("Podaj " + size + " liczb oddzielonych spacja");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.nextLine();
            return array;
        } catch (Exception e) {
            System.out.println("Błąd przy odczytywaniu danych" + e.getMessage());
            return null;
        }
    }
}
