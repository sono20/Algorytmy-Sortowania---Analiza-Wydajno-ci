public class Timer {

    public static final int NUM_TRIALS = 15;

    public static double measureTime(int[] array, Algorithm algorithm){;
        long start = System.nanoTime();
        algorithm.sort(array);
        long end = System.nanoTime();
        return end-start;
    }

    public static double averageTime(int size, Algorithm algorithm, String caseType){
        double totalTime = 0;

        for (int i=0;i<NUM_TRIALS; i++){

            int[] testArray = switch (caseType){
                case "średni"-> ArrayGenerator.random(size);
                case "pesymistyczny" -> getWorstCaseArray(size, algorithm);
                default -> ArrayGenerator.random(size);
            };

            totalTime += measureTime(testArray,algorithm);
        }
        return totalTime / NUM_TRIALS;
    }
    private static int[] getWorstCaseArray(int size, Algorithm algorithm){
        return switch(algorithm){
            case QUICK_SORT -> ArrayGenerator.randomSorted(size);
            case INSERTION_SORT -> ArrayGenerator.randomReversed(size);
            case SELECTION_SORT -> ArrayGenerator.random(size);
            case MERGE_SORT -> ArrayGenerator.random(size);
            default -> ArrayGenerator.random(size);
        };
    }
}
