package org.landy.business.identify.customer.domain;

import java.util.Date;

/**
 * 会员明细相关信息
 */
public class CustomerDetail {

    private Integer customerDetailId;
    private Integer requestId;
    private Integer applicationId;
    private Integer memberNumber;
    private Integer customerId;
    private Integer categoryClassId;
    private Date birthDate;
    private String firstName;

    public Integer getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(Integer customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCategoryClassId() {
        return categoryClassId;
    }

    public void setCategoryClassId(Integer categoryClassId) {
        this.categoryClassId = categoryClassId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
