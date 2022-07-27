package leetcode.editor.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Sort {

    protected Integer[] getArray(int length, long seed) {
        Random random = new Random(seed);
        return IntStream.range(0, length)
                .mapToObj(i -> random.nextInt(100))
                .toArray(Integer[]::new);
    }

    public void test() {
        long seed = System.currentTimeMillis();
        Integer[] array = getArray(20, seed);
        System.out.println(Arrays.toString(array));

        Integer[] jdk = getArray(20, seed);
        Arrays.sort(jdk);
        System.out.println(Arrays.toString(jdk));

        Integer[] self = getArray(20, seed);
        sort(self);
        System.out.println(Arrays.toString(self));
    }

    protected abstract void sort(Integer[] array);

    protected void swap(Integer[] array, int i, int j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

