package org.landy.business.identify.component.primary;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;

/**
 * 组合主键查询标准接口（责任链模式）
 * @author landyl
 * @create 3:21 PM 09/05/2018
 */
public interface KeyIdentificationChain {

    IdentificationResultType doIdentify(IdentifyCriterion identifyCriterion, WorkflowEnum workflowId);

    KeyIdentificationChain addIdentification(KeyIdentification identification, WorkflowEnum workflowId);

}
