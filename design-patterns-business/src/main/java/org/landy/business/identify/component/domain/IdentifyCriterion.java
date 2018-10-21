package org.landy.business.identify.component.domain;

import java.util.Date;

/**
 * @author landyl
 * @create 3:34 PM 09/05/2018
 */
public class IdentifyCriterion {

    private Integer sourceId;
    private Integer requestId;
    private Integer memberNumber;
    private Integer customerId;
    private Integer categoryClassId;
    private Date birthDate;
    private String firstName;
    private Long orderId;
    private String statusCode;
    private Date statusDate;
    private Date effectiveDate;

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
