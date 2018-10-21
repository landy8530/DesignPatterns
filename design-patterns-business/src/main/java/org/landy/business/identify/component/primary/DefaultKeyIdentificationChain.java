package org.landy.business.identify.component.primary;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.domain.IdentifyCriterion;
import org.landy.business.identify.component.enums.IdentificationResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 组合主键查询责任链默认实现
 * @author landyl
 * @create 3:42 PM 09/05/2018
 */
@Component
public class DefaultKeyIdentificationChain implements KeyIdentificationChain {
    private static Logger LOGGER = LoggerFactory.getLogger(DefaultKeyIdentificationChain.class);

    Map<WorkflowEnum,List<KeyIdentification>> identifyMap = new ConcurrentHashMap<>();
    Map<WorkflowEnum,Integer> identifyIndexMap = new ConcurrentHashMap<>();

    /**
     * The int which is used to maintain the current position int the keyIdentification chain
     */
    private int index = 0;

    @Override
    public IdentificationResultType doIdentify(IdentifyCriterion identifyCriterion, WorkflowEnum workflowId) {
        List<KeyIdentification> identifications = identifyMap.get(workflowId);

        if(identifyIndexMap.containsKey(workflowId)) {
            index = identifyIndexMap.get(workflowId) == null ? 0 : identifyIndexMap.get(workflowId);
        } else {
            index = 0;
        }

        if(index == identifications.size()) return IdentificationResultType.NO_MATCH;

        KeyIdentification keyIdentification = identifications.get(index);
        index ++;

        identifyIndexMap.put(workflowId,index);

        return keyIdentification.doIdentify(identifyCriterion,this);
    }

    @Override
    public KeyIdentificationChain addIdentification(KeyIdentification identification, WorkflowEnum workflowId) {
        // Prevent the same filter being added multiple times
        List<KeyIdentification> identifications ;
        if(identifyMap.containsKey(workflowId)) {
            identifications = identifyMap.get(workflowId);
        } else {
            identifications = new ArrayList<>(0);
        }

        for(KeyIdentification v : identifications) {
            if(v.equals(identification)) {
                return this;
            }
        }

        identifications.add(identification);

        LOGGER.info("Added the identification: {} successfully!",identification.getClass());

        identifyMap.put(workflowId,identifications);
        return this;
    }

    public void clearIdentifications() {
        if(identifyIndexMap != null) {
            identifyIndexMap.clear();
        }
    }

    public void doClearIdentificationIndex(WorkflowEnum workflowId) {
        if(identifyIndexMap.containsKey(workflowId)) {
            index = 0;
            identifyIndexMap.put(workflowId,index);
        }
    }
}
