package org.landy.business.identify.component;

import org.landy.business.enums.WorkflowEnum;
import org.landy.business.identify.component.enums.IdentificationStrategy;
import org.landy.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象查询控件模板类（适应不同业务流程以及不同主键查询策略）
 * The component standard identify process
 * @author landyl
 * @create 2:46 PM 09/25/2018
 */
public abstract class AbstractIdentify {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractIdentify.class);

    protected static Map<String,String> identifyHandlerMap = new HashMap<>();

    public AbstractIdentify() {
        LOGGER.info("To add a identify process component,key={},beanName={}.",keyOfMap(),accessBeanName());
        identifyHandlerMap.put(keyOfMap(),accessBeanName());
    }

    protected abstract IdentificationStrategy accessIdentificationStrategy();

    protected abstract WorkflowEnum accessWorkflow();

    protected abstract String accessBeanName();

    private String keyOfMap() {
        return keyOfMap(accessWorkflow(), accessIdentificationStrategy());
    }

    protected final static String keyOfMap(WorkflowEnum updateWorkflowId, IdentificationStrategy identificationType) {
        return updateWorkflowId.name() + Constants.DELIMITER_UNDERSCORE + identificationType.name;
    }
}
