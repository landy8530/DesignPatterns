package org.landy.template.method.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author landyl
 * @create 4:08 PM 05/12/2018
 */
public class Test {

    public static void main(String[] args) {
        //对整型数组排序
        int[] intArray = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int operations = new IntBubbleSorter().sort(intArray);
        System.out.println("[Template Method] operations:" + operations + ", array:" + Arrays.toString(intArray));

        //对double数组排序
        double[] doubleArray = {9.9, 8.8, 7.7, 6.6, 5.5, 4.4, 3.3, 2.2, 1.1, 0.0};
        operations = new DoubleBubbleSorter().sort(doubleArray);
        System.out.println("[Template Method] operations:" + operations + ", array:" + Arrays.toString(doubleArray));

        //对List集合排序
        List<Integer> list = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        operations = new IntegerListSorter().sort(list);
        System.out.println("[Template Method] operations:" + operations + ", list:" + list.toString());
    }

}
