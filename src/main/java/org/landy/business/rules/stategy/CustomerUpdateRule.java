package org.landy.business.rules.stategy;

import org.landy.business.rules.annotation.StatusCheck;
import org.landy.business.rules.domain.CheckResult;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 2:22 PM 09/30/2018
 */
@Component
public class CustomerUpdateRule  implements UpdateRule { //

    //利用自定义注解，进行AOP切面编程，进行其他业务逻辑的校验操作
    @StatusCheck
    public CheckResult check(String updateStatus, String currentStatus) {
        System.out.println("CustomerUpdateRule:在此还有其他业务校验逻辑。。。。"+updateStatus + "____" + currentStatus);
        return new CheckResult();
    }

}
