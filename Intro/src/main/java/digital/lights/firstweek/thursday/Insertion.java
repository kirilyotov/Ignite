package digital.lights.firstweek.thursday;

public class Insertion implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int elem = arr[i];
            int index = i - 1;

            while (index >= 0 && arr[index] > elem) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = elem;
        }
    }
}
