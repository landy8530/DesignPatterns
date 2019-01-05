import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Landy on 2018/11/11.
 */
public class Test {

    public static void main(String[] args) {
        // 要验证的字符串
//        String str = "#(1234&&sa5(as！@#￥%……&*（）——+saaabc))0001000005.20#";
        String str = "select * from aa where a = 'bbbb' and b = 'ccccc' and c=N'dddd' and d='eeee'";//
        // 正则表达式规则
//        String regEx = "^#\\(\\)$#";
        String regEx = "(?<=\\()(\\S+)(?=\\))";
//        Pattern pattern = Pattern.compile("[^N]['][\\s\\S^']*?'");
        Pattern pattern = Pattern.compile("(?<=')(\\S+)(?=')");
        // 编译正则表达式
//        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
//        String[] s = pattern.split(str);
////         查找字符串中是否有匹配正则表达式的字符/字符串
//        System.out.println(s);
//        for(String ss :s) {
//            System.out.println(ss);
//        }
//        System.out.println(matcher.start());
//        System.out.println(matcher.end());

//        boolean rs = matcher.find();
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
//        System.out.println(rs);
    }

}
