package defaultmethod;

/**
 * @author: landy
 * @date: 2019/5/19 09:35
 * @description:
 */
public class InterfaceConflict implements Addition, Additional {

    /**
     * 接口冲突：如果一个父接口提供一个默认方法，
     * 而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），
     * 那么必须覆盖该方法来解决冲突
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b) {
        return a + b + 5;
    }
}
