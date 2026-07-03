import java.io.File;

public class MyFile1 {
    public static void main(String[] args) {
          /*
        public File(String pathname)                根据文件路径创建文件对象
        public File(String parent, String child)    根据父路径名字符串和子路径名字符串创建文件对象
        public File(File  parent, String child)     根据父路径对应文件对象和子路径名字符串创建文件对象

        C:\Users\alienware\Desktop
    */
        File f1=new File("C:\\Users\\alienware\\Desktop\\a.txt");
        System.out.println(f1);

        String parent="C:\\Users\\alienware\\Desktop";
        String child="a.txt";
        File f2=new File(parent,child);
        System.out.println(f2);

        File f3=new File("C:\\Users\\alienware\\Desktop");
        File f4=new File(f3,"a.txt");
        System.out.println(f4);
    }
}
