package org.landy.business.identify.component.primary;

import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;

/**
 * 组合主键查询接口
 * @author landyl
 * @create 3:25 PM 09/05/2018
 */
public interface KeyIdentification {

    IdentificationResultType doIdentify(IdentifyCriterion identifyCriterion, KeyIdentificationChain chain);

}
