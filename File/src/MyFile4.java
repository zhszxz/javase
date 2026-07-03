import java.io.File;

public class MyFile4 {
    public static void main(String[] args) {
        File f1=new File("C:\\Users\\user\\Desktop\\4.STM32参考资料");
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
