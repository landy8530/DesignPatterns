package org.landy.business.domain.file;

import org.landy.business.domain.detail.XHFRequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 9:46 AM 05/08/2018
 */
public class XHFRequestFile extends RequestFile<XHFRequestDetail> {
    public static final String[] xhfDetailHeaders = {
            "ROW_NUMBER", "SYSTEM_SOURCE", "SYSTEM_SOURCE_ID","MEMBER_NUMBER"
    };

    private List<XHFRequestDetail> requestBOBDetails;

    @Override
    public List<XHFRequestDetail> getRequestDetails() {
        return getRequestBOBDetails();
    }

    @Override
    public String[] getDetailHeaders() {
        return xhfDetailHeaders;
    }

    @Override
    public WorkflowEnum getProcessWorkFlow() {
        return WorkflowEnum.XHF;
    }

    private List<XHFRequestDetail> getRequestBOBDetails() {
        if (requestBOBDetails == null) {
            List<String> detailLines = getDetailLines();

            if (detailLines == null) return null;

            XHFRequestDetail detail;
            requestBOBDetails = new ArrayList<>();
            for (String detailLine : detailLines) {
                detail = parseDetailLinesToRequestBOBDetail(detailLine);
                requestBOBDetails.add(detail);
            }
        }

        return requestBOBDetails;
    }

    private XHFRequestDetail parseDetailLinesToRequestBOBDetail(String detailLine) {
        XHFRequestDetail detail = new XHFRequestDetail();
        String[] detailValues = detailLine.split(Constants.DELIMITER_PIPE);
        parseToDetail(detail,detailValues);
        return detail;
    }

}
