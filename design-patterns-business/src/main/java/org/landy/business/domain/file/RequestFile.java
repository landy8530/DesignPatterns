package org.landy.business.domain.file;

import org.apache.commons.lang.StringUtils;
import org.landy.business.domain.detail.RequestDetail;
import org.landy.business.enums.WorkflowEnum;
import org.landy.constants.Constants;
import org.landy.utils.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class RequestFile<T extends RequestDetail> {
    private String fileName;
    private String networkId;
    private String issueId;
    private String updateStatus;
    private Date processDate;

    private List<String> textLines;
    private List<String> detailLines;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getTextLines() {
        return textLines;
    }

    public void setTextLines(List<String> textLines) {
        this.textLines = textLines;
    }

    public boolean isFileTypeValid() {
        if (!FileUtil.isTextFile(fileName)) return false;

        return true;
    }

    public boolean isCreationDateValid() {
        String[] nameParts = fileName.split(Constants.DELIMITER_UNDERSCORE);
        int dateIndex = nameParts.length - 3;
        Date creationDate = DateUtil.string2Date(nameParts[dateIndex++] + "_" + nameParts[dateIndex], DateUtil.DATE_TIME_PATTERN_1);
        return DateUtil.dayDifferenceIgnoreTime(creationDate, new Date()) == 0;
    }

    public boolean isFileRowCountValid() {
        String[] nameParts = fileName.split(Constants.DELIMITER_UNDERSCORE);
        String countStr = nameParts[nameParts.length - 1];
        int dotPosition = countStr.indexOf(".");
        int count = StringUtil.string2Integer(countStr.substring(0, dotPosition));

        return count == textLines.size() - 6;
    }

    public boolean isFileLayoutValid() {
        for (int i = 0 ; i < textLines.size(); i++) {
            if (i == 4 && !"".equals(textLines.get(i))) return false;

            if (i != 4 && StringUtils.isEmpty(textLines.get(i))) return false;
        }

        return true;
    }

    public boolean isHeaderValid() {
        String headerLine = textLines.get(5);
        if (StringUtils.isEmpty(headerLine)) return false;

        String[] headers = headerLine.split(Constants.DELIMITER_PIPE);
        if (!Arrays.deepEquals(headers, getDetailHeaders())) return false;

        return true;
    }

    public String getNetworkId() {
        if (StringUtils.isEmpty(networkId)) {
            networkId = KeyValueUtil.getValue(textLines.get(0));
        }

        return networkId;
    }

    public String getIssueId() {
        if (StringUtils.isEmpty(issueId)) {
            issueId = KeyValueUtil.getValue(textLines.get(1));
        }

        return issueId;
    }
    
    public String getUpdateStatus() {
        if (StringUtils.isEmpty(updateStatus)) {
        	updateStatus = KeyValueUtil.getValue(textLines.get(2));
        }

        return updateStatus;
    }

    public Date getProcessDate() {
        if (processDate == null) {
            String processDateStr = KeyValueUtil.getValue(textLines.get(3));
            if ("trunc(sysdate)".equals(processDateStr)) {
                processDateStr = DateUtil.date2String(new Date());
            }

            if (StringUtils.isEmpty(processDateStr)) return null;

            if (!DateUtil.isValidDate(processDateStr, DateUtil.DATE_PATTERN_DEFAULT)) {
                return null;
            }

            processDate = DateUtil.string2Date(processDateStr);
        }

        return processDate;
    }

    public List<String> getDetailLines() {
        if (detailLines == null) {
            detailLines = textLines.subList(6, textLines.size());
        }

        return detailLines;
    }

    public abstract List<T> getRequestDetails();

	public abstract WorkflowEnum getProcessWorkFlow();

    public abstract String[] getDetailHeaders();

    protected void parseToDetail(T detail,String[] detailValues) {
        String propertyName;
        String propertyValue;
        for (int i = 0; i < detailValues.length; i++) {
            propertyValue = detailValues[i];

            if (StringUtils.isEmpty(propertyValue)) continue;

            propertyName = CamelCaseUtil.toCamelCase(getDetailHeaders()[i]);
            BeanUtil.setProperty(detail, propertyName, propertyValue);
        }
    }

}
