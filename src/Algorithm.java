public enum Algorithm {
    INSERTION_SORT("Insertion Sort"), MERGE_SORT("Merge Sort"), QUICK_SORT("Quick Sort"), SELECTION_SORT("Selection Sort");
    private final String name;

    Algorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sort(int[] array) {
        switch (this) {
            case INSERTION_SORT -> InsertionSort.sort(array);
            case MERGE_SORT -> MergeSort.sort(array, 0, array.length - 1);
            case QUICK_SORT -> QuickSort.sort(array, 0, array.length - 1);
            case SELECTION_SORT -> SelectionSort.sort(array);
        }
    }
}
