package leetcode.editor.sort;

public class Bubble extends Sort {

    @Override
    public void sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Bubble().test();
    }
}
