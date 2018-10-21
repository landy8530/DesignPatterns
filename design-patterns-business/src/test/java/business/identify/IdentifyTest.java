package business.identify;

import org.junit.Test;
import org.landy.business.identify.customer.facade.CustomerIdentifyFacade;
import org.landy.business.identify.order.facade.OrderIdentifyFacade;
import test.SpringTestBase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author landyl
 * @create 9:16 AM 09/30/2018
 */
public class IdentifyTest extends SpringTestBase {

    @Autowired
    private OrderIdentifyFacade orderIdentifyFacade;

    @Autowired
    private CustomerIdentifyFacade customerIdentifyFacade;

    @Test
    public void orderIdentifyTest() {
        //在此只是简单的测试一下功能而已，没有数据库操作
        orderIdentifyFacade.identifyOrders(-1);
    }

    @Test
    public void customerIdentifyTest() {
        //在此只是简单的测试一下功能而已，没有数据库操作
        customerIdentifyFacade.identifyCustomers(-1);
    }

}
