package org.landy.business.validation;

import org.landy.constants.Constants;

/**
 * @author landyl
 * @create 16:25 05/10/2019
 */
public class ValidationResult {

    private int resultId;
    private String resultMsg;

    /**
     * Default constructor
     */
    public ValidationResult() {
        this(Constants.UNPROCESSED);
    }

    public ValidationResult(int resultId) {
        this.resultId = resultId;
    }

    public ValidationResult(int resultId, String resultMsg) {
        this.resultId = resultId;
        this.resultMsg = resultMsg;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
