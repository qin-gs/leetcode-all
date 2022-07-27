package leetcode.editor.sort;

public class Merge extends Sort {
    @Override
    public void sort(Integer[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(Integer[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    /**
     * 合并
     */
    private void merge(Integer[] array, int left, int mid, int right) {
        Integer[] tmp = new Integer[right - left + 1];
        int l = left, r = mid + 1, index = 0;
        while (l <= mid && r <= right) {
            if (array[l] > array[r]) {
                tmp[index++] = array[r++];
            } else {
                tmp[index++] = array[l++];
            }
        }
        while (l <= mid) {
            tmp[index++] = array[l++];
        }
        while (r <= right) {
            tmp[index++] = array[r++];
        }
        System.arraycopy(tmp, 0, array, left, tmp.length);
    }

    public static void main(String[] args) {
        new Merge().test();
    }

}
