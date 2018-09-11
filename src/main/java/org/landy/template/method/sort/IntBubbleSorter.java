package org.landy.template.method.sort;

/**
 * @author landyl
 * @create 4:01 PM 05/12/2018
 */
public class IntBubbleSorter extends BubbleSorter<int[]> {

    private int[] array;

    @Override
    protected void setArray(int[] array) {
        this.array = array;
    }

    @Override
    protected int getLength() {
        return array == null ? 0 : array.length;
    }

    @Override
    protected boolean needSwap(int index) {
        return array != null && (array[index] > array[index + 1]);
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }
}
