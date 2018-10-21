package org.landy.business.rules.domain;


import org.landy.constants.Constants;

/**
 * 
 * @author Landyl
 *
 */
public class CheckResult {
	private int checkResult;
	private String checkMessage;
	
	public CheckResult(){
		this(Constants.UPDATE_STATUS_VALID_UPDATE);
	}
	
	public CheckResult(int checkResult) {
		this.checkResult = checkResult;
	}

	public CheckResult(int checkResult, String checkMessage) {
		this.checkResult = checkResult;
		this.checkMessage = checkMessage;
	}



	public int getCheckResult() {
		return checkResult;
	}
	
	public void setCheckResult(int checkResult) {
		this.checkResult = checkResult;
	}
	
	public String getCheckMessage() {
		return checkMessage;
	}
	
	public void setCheckMessage(String checkMessage) {
		this.checkMessage = checkMessage;
	}
}
