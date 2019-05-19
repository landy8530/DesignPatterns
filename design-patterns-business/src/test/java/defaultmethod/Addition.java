package defaultmethod;

/**
 * @author: landy
 * @date: 2019/5/19 09:29
 * @description:
 */
public interface Addition {

    default int add(int a, int b) {
        return a + b;
    }

}
