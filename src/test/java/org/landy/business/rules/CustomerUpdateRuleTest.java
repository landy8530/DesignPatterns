package org.landy.business.rules;

import org.junit.Test;
import org.landy.business.rules.domain.CheckResult;
import org.landy.business.rules.stategy.CustomerUpdateRule;
import org.landy.test.SpringTestBase;
import org.landy.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author landyl
 * @create 2:32 PM 09/30/2018
 */
public class CustomerUpdateRuleTest extends SpringTestBase {

    @Autowired
    private CustomerUpdateRule customerUpdateRule;

    @Test
    public void customerCheckTest() {
        //ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigure.class);
        System.out.println("customerCheckTest");
        CheckResult checkResult = customerUpdateRule.check("2","currentStatus");
        AssertUtil.assertTrue(checkResult.getCheckResult() == 0,"与预期结果不一致");
    }

}
