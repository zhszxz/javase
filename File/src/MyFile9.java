import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyFile9 {
    public static void main(String[] args) {
        /*
            需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）

        */

        HashMap<String, Integer> count = getCount(new File("D:\\Typora"));
        System.out.println(count);
    }
    public static HashMap<String,Integer> getCount(File src){
        HashMap<String,Integer> hm=new HashMap<>();
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                String[] split = file.getName().split("\\.");
                String endName = split[split.length - 1];
                if(hm.containsKey(endName)){
                    hm.put(endName,hm.get(endName)+1);
                }
                else{
                    hm.put(endName,1);
                }
            }
            else{
                HashMap<String, Integer> sonCount = getCount(file);
                Set<Map.Entry<String, Integer>> entries = sonCount.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String key=entry.getKey();
                    if(hm.containsKey(key)){
                        hm.put(key,hm.get(key)+entry.getValue());
                    }
                    else{
                        hm.put(key,entry.getValue());
                    }
                }
            }
        }
        return hm;
    }
}
