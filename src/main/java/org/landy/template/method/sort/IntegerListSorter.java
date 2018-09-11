package org.landy.template.method.sort;

import java.util.List;

/**
 * @author landyl
 * @create 4:06 PM 05/12/2018
 */
public class IntegerListSorter extends BubbleSorter<List<Integer>> {
    private List<Integer> list;

    @Override
    protected void setArray(List<Integer> array) {
        this.list = list;
    }

    @Override
    protected int getLength() {
        return list == null ? 0 : list.size();
    }

    @Override
    protected boolean needSwap(int index) {
        return list != null && (list.get(index) > list.get(index + 1));
    }

    @Override
    protected void swap(int index) {
        int temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }
}
