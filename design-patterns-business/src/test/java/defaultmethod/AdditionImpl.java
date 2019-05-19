package defaultmethod;

/**
 * @author: landy
 * @date: 2019/5/19 09:30
 * @description:
 */
public class AdditionImpl implements Addition {

    /**
     * 接口默认方法的 ”类优先” 原则：若一个接口中定义了一个默认方法，
     * 而另外一个父类或接口中又定义了一个同名的方法时选择父类中的方法：
     * 如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略。
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b) {
        return a + b + 10;
    }
}
