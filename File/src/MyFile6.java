import java.io.File;

public class MyFile6 {
    public static void main(String[] args) {
         /*需求：
             定义一个方法找某一个文件夹中，是否有以MP4结尾的电影。
	        （暂时不需要考虑子文件夹）
        */
        File f1=new File("E:\\videos");
        System.out.println(hasMP4(f1));
    }

    private static boolean hasMP4(File f1) {
        File[] files = f1.listFiles();
        for (File file : files) {
            if(file.isFile()&&file.getName().endsWith(".mp4"))
                return true;
        }
        return false;
    }
}
