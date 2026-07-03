import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFile2 {
    public static void main(String[] args) throws ParseException {
         /*
        public long length()                返回文件的大小（字节数量）
        public String getAbsolutePath()     返回文件的绝对路径
        public String getPath()             返回定义文件时使用的路径
        public String getName()             返回文件的名称，带后缀
        public long lastModified()          返回文件的最后修改时间（时间毫秒值）
     */
        File f1=new File("D:\\Java\\Java基础-资料2\\day27-IO(异常&File&综合案例）\\代码\\myfile\\src\\com\\itheima\\a01myfile\\FileDemo1.java");
        System.out.println(f1.length());

        System.out.println(f1.getAbsoluteFile());

        File f2=new File("File\\a");
        System.out.println(f2.getPath());

        System.out.println(f2.getName());

        System.out.println(f1.lastModified());

        Date d=new Date(f1.lastModified());
        SimpleDateFormat sdf=new SimpleDateFormat("yy年MM月dd日 HH时mm分ss秒");
        System.out.println(sdf.format(d));

        String data="22年11月02日 16时48分38秒";
        Date d2 = sdf.parse(data);
        System.out.println(d2);
    }
}
