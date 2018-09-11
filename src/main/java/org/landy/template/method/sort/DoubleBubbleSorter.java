package org.landy.template.method.sort;

/**
 * @author landyl
 * @create 4:02 PM 05/12/2018
 */
public class DoubleBubbleSorter extends BubbleSorter<double[]> {

    private double[] array;

    @Override
    protected void setArray(double[] array) {
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
        double temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

}
