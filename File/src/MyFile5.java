import java.io.File;
import java.io.IOException;

public class MyFile5 {
    public static void main(String[] args) throws IOException {
        //需求：在当前模块下的aaa文件夹中创建一个a.txt文件
        File f1=new File("aaa");
        f1.mkdirs();
        File f2=new File(f1,"aaa.txt");
        boolean newFile = f2.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
        else{
            System.out.println("创建失败");
        }
    }
}
