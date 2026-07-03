import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，\n" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台\n" ;
        //获取正则表达式对象
        Pattern p=Pattern.compile("Java\\d{1,2}");
        //m:文本匹配器。在str中匹配符合p的小串
        Matcher m=p.matcher(str);
        //若成功匹配，返回true并记录字串的起始索引和结束索引加1
       while(m.find()) {
           //根据记录的索引截取子串
           String substring = m.group();
           System.out.println(substring);
       }
    }
}