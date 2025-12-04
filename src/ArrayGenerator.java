import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {
    private static Random random = new Random();

    public static int[] random(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    public static int[] sorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] reversed(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = 10000 - (i * 10000 / size);
        }
        return array;
    }

    public static int[] randomSorted(int size) {
        int[] array = random(size);
        Arrays.sort(array);
        return array;
    }

    public static int[] randomReversed(int size) {
        int[] array = random(size);
        Arrays.sort(array);
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        return array;

    }
}
