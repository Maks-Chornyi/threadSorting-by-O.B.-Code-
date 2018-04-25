import java.util.Random;

public class Data {

    public void startSorting(int arrSize) {
        int[] array = new int[arrSize];
        int[] arrayMulti = new int[arrSize];
        fillArray(array, arrayMulti);

        long start = System.currentTimeMillis();
        new SingleSort().bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.printf("%d, ms spent on SINGLE sorting %d elements\n", end - start,arrSize);
        start = System.currentTimeMillis();
        multiSorting(arrayMulti);
        end = System.currentTimeMillis();
        System.out.printf("%d, ms spent on MULTY sorting %d elements\n", end - start,arrSize);
    }


    private void fillArray(int[] array, int[] arrayMulti) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length);
        }
        System.arraycopy(array, 0, arrayMulti, 0, array.length);
    }


    private void multiSorting(int[] array) {
        Thread t1 = new Thread(new MultiSort(array, 1));
        Thread t2 = new Thread(new MultiSort(array, 2));
        t1.start();
        t2.start();
        new SingleSort().bubbleSort(array);
    }
}