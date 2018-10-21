package business.validator;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.landy.business.RequestValidator;
import org.landy.business.domain.file.XHFRequestFile;
import org.landy.business.domain.file.PolicyRequestFile;
import org.landy.business.domain.file.RequestFile;
import org.landy.constants.Constants;
import test.SpringTestBase;
import org.landy.utils.AssertUtil;
import org.landy.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author landyl
 * @create 3:51 PM 05/13/2018
 */
public class RequestValidatorTest extends SpringTestBase {

    @Autowired
    private RequestValidator requestValidator;

    @Test
    public void testValidation() throws IOException {
        String filePath = FileUtil.getFilePathByClassPath("/org/landy/business");
//        String fileName = "test_20180517_102637_324.txt";
        String fileName = "org.landy/business/xhf_integration_20180716_101705_2.txt";
        RequestFile requestFile;
        if (fileName.startsWith("xhf_policy_")) {
            requestFile = new PolicyRequestFile();
        } else {
            requestFile = new XHFRequestFile();
        }

        requestFile.setFileName(fileName);

        String validationResult;
        //校验文件头
        validationResult = requestValidator.validateFileInfo(requestFile);
        AssertUtil.assertTrue(Constants.VALID.equals(validationResult), validationResult);

        File archiveFile = new File(filePath + File.separator + fileName);

        System.out.println(archiveFile.getAbsolutePath());

        List<String> textLines = FileUtils.readLines(archiveFile, Constants.ENCODING_UTF8);
        requestFile.setTextLines(textLines);
        System.out.println("校验文件前，文件明细行数为:" + requestFile.getDetailLines().size());
        //校验文件里的概要信息
        validationResult = requestValidator.validateSummary(requestFile);
        AssertUtil.assertTrue(Constants.VALID.equals(validationResult), validationResult);
        //校验文件中的列名
        validationResult = requestValidator.validateHeaders(requestFile);
        AssertUtil.assertTrue(Constants.VALID.equals(validationResult), validationResult);
        //校验文件明细
        validationResult = requestValidator.validateDetails(requestFile);
        AssertUtil.assertTrue(Constants.VALID.equals(validationResult), validationResult);

        System.out.println("校验文件后，文件明细数目为:" + requestFile.getRequestDetails().size());

    }

}
