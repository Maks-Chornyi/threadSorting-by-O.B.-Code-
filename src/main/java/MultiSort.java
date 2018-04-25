import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MultiSort implements Runnable {

    private int [] array;
    private int threadNum;

    @Override
    public void run () {
        int range = array.length/2;
        int start, temp;

        if (threadNum == 1)
            start = 0;
        else
            start = (threadNum - 1) * range;

        for (int i = start; i < start + range; i++) {
            for (int j = i + 1; j < start + range; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
