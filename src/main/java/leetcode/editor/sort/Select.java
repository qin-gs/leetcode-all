package leetcode.editor.sort;

/**
 * 选择后面最小的数与当前交换
 */
public class Select extends Sort {

    @Override
    public void sort(Integer[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            // 选择 i -- length 中最小的值
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        new Select().test();
    }
}
