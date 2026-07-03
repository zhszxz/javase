import java.io.File;

public class MyFile8 {
    public static void main(String[] args) {
        delete(new File("E:\\videos"));
    }
    public static void delete(File src){
        File[] files = src.listFiles();
        if (files != null) {

            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                } else {
                    delete(file);
                }
            }

        src.delete();

        }
    }
}
