import java.io.File;
import java.io.IOException;

public class MyFile3 {
    public static void main(String[] args) throws IOException {
          /*
        public boolean createNewFile()      创建一个新的空的文件
        public boolean mkdir()              创建单级文件夹
        public boolean mkdirs()             创建多级文件夹
        public boolean delete()             删除文件、空文件夹
      */
        File f1=new File("C:\\Users\\user\\Desktop\\a.txt");
        System.out.println(f1.createNewFile());

        File f2=new File("C:\\Users\\user\\Desktop\\files");
        System.out.println(f2.mkdir());

        File f3=new File("C:\\Users\\user\\Desktop\\aaa\\bbb\\ccc");
        System.out.println(f3.mkdirs());

        System.out.println(f1.delete());

        System.out.println(f2.delete());
        System.out.println("=====================");
        System.out.println(f3.delete());

    }
}
