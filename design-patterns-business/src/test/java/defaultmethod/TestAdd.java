package defaultmethod;

/**
 * @author: landy
 * @date: 2019/5/19 09:30
 * @description:
 */
public class TestAdd {

    public static void main(String[] args) {
        Addition addition = new AdditionImpl();
        System.out.println(addition.add(10,10));

        Addition addition1 = new AdditionImpl2();
        System.out.println(addition1.add(10,10));

        InterfaceConflict ic = new InterfaceConflict();
        System.out.println(ic.add(10,10));

    }

}
