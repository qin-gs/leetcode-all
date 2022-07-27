package leetcode.editor.sort;

public class Insert extends Sort {
    @Override
    public void sort(Integer[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            index = i;
            while (index > 0) {
                if (array[index] < array[index - 1]) {
                    swap(array, index - 1, index);
                    index--;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Select().test();
    }
}
