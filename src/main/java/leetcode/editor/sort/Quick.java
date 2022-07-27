package leetcode.editor.sort;

import java.util.Arrays;

/**
 * 快速排序：选择一个基准，将这一个数放到正确的位置 (左边的数都小于该值，右边的都大于该值)
 */
public class Quick extends Sort {

    @Override
    public void sort(Integer[] array) {
        quick(array, 0, array.length - 1);
    }

    private void quick(Integer[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quick(array, left, index - 1);
            quick(array, index + 1, right);
        }
    }

    private int partition(Integer[] array, int left, int right) {
        // 记录第一个数字
        int tmp = array[left];
        // 让左边的小于 tmp，右边的大于 tmp
        while (left < right) {
            while (right > left && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        // 把第一个数字放到正确的位置
        array[left] = tmp;
        return left;
    }

    public static void main(String[] args) {
        new Quick().test();
    }

}
