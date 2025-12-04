import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==========MENU GŁÓWNE==========");
        System.out.println("1. Test na odgórnie podanej tablicy");
        System.out.println("2. Test na testowej tablicy z konsoli");
        System.out.println("3. Test na tablicy z pliku tekstowego");
        System.out.println("4. Test skalowalności");
        System.out.println("0. Wyjście");
        System.out.print("Wybierz opcję poprzez wpisanie: 1, 2, 3, 4 lub 0: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1 -> TestRunner.testPredefinedArray();
            case 2 -> TestRunner.testConsoleArray(scanner);
            case 3 -> TestRunner.testFileArray(scanner);
            case 4 -> TestRunner.testScalability();
            case 0 -> System.out.println("Do widzenia");
            default -> System.out.println("Nieprawidłowa opcja");
        }

        scanner.close();
    }
}