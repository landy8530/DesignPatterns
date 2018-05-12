package org.landy.builder.domain;

/**
 * @author landyl
 * @create 5:05 PM 05/12/2018
 */
public class Member {

    private String memberId;
    private String memberName;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return " 成员信息：" + memberId + "---" + memberName;
    }

}
