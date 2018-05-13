package org.landy.business.domain.detail;

public class PolicyRequestDetail extends RequestDetail {

    private String parentCarrierId;
    private String applicationId;
    private String policyId;
    private String productLine;
    private String categoryClassId;
    private String birthDate;
    private String fullName;
    private String revenueImpactDate;
    private String policyNumber;

    private String monthlyPremium;
    private String rateTier;
    private String raf;	// SMB only
    private String notCancelled;
    private String isDelinquent;
    private String delinquencyNote;
    private String memberCount;
    private String isActive;
    private String isReversed;
    private String isMasterPolicy;
    private String category;
    private String subscriberCount;
    private String addressLine3;
    private String county;
    private String businessLine;
    private String groupName;


    public String getParentCarrierId() {
        return parentCarrierId;
    }

    public void setParentCarrierId(String parentCarrierId) {
        this.parentCarrierId = parentCarrierId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getCategoryClassId() {
        return categoryClassId;
    }

    public void setCategoryClassId(String categoryClassId) {
        this.categoryClassId = categoryClassId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRevenueImpactDate() {
        return revenueImpactDate;
    }

    public void setRevenueImpactDate(String revenueImpactDate) {
        this.revenueImpactDate = revenueImpactDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getMonthlyPremium() {
        return monthlyPremium;
    }

    public void setMonthlyPremium(String monthlyPremium) {
        this.monthlyPremium = monthlyPremium;
    }

    public String getRateTier() {
        return rateTier;
    }

    public void setRateTier(String rateTier) {
        this.rateTier = rateTier;
    }

    public String getRaf() {
		return raf;
	}

	public void setRaf(String raf) {
		this.raf = raf;
	}

	public String getNotCancelled() {
        return notCancelled;
    }

    public void setNotCancelled(String notCancelled) {
        this.notCancelled = notCancelled;
    }

    public String getIsDelinquent() {
        return isDelinquent;
    }

    public void setIsDelinquent(String isDelinquent) {
        this.isDelinquent = isDelinquent;
    }

    public String getDelinquencyNote() {
        return delinquencyNote;
    }

    public void setDelinquencyNote(String delinquencyNote) {
        this.delinquencyNote = delinquencyNote;
    }

    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsReversed() {
        return isReversed;
    }

    public void setIsReversed(String isReversed) {
        this.isReversed = isReversed;
    }

    public String getIsMasterPolicy() {
        return isMasterPolicy;
    }

    public void setIsMasterPolicy(String isMasterPolicy) {
        this.isMasterPolicy = isMasterPolicy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(String subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
