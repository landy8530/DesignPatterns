package org.landy.business.rules.stategy;

import org.landy.business.rules.domain.CheckResult;

/**
 * @author landyl
 * @create 3:08 PM 09/30/2018
 */
public interface UpdateRule {
    CheckResult check(String updateStatus, String currentStatus);
}
