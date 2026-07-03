import java.util.*;

//贪心算法解决集合覆盖问题
public class GreedyAlgorithm {
    //有若干个广播站，每个都有自己的覆盖范围（有重复），问如何在选择最少广播站的情况下，覆盖所有地区
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();//存放所有广播站
        HashSet<String> broadcast1 = new HashSet<>();
        broadcast1.add("北京");
        broadcast1.add("上海");
        broadcast1.add("天津");
        HashSet<String> broadcast2 = new HashSet<>();
        broadcast2.add("广州");
        broadcast2.add("北京");
        broadcast2.add("深圳");
        HashSet<String> broadcast3 = new HashSet<>();
        broadcast3.add("成都");
        broadcast3.add("上海");
        broadcast3.add("杭州");
        HashSet<String> broadcast4 = new HashSet<>();
        broadcast4.add("上海");
        broadcast4.add("天津");
        HashSet<String> broadcast5 = new HashSet<>();
        broadcast5.add("杭州");
        broadcast5.add("大连");
        broadcasts.put("k1", broadcast1);
        broadcasts.put("k2", broadcast2);
        broadcasts.put("k3", broadcast3);
        broadcasts.put("k4", broadcast4);
        broadcasts.put("k5", broadcast5);
        HashSet<String> allArea = new HashSet<>();//存放所有未覆盖地区
        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("成都");
        allArea.add("杭州");
        allArea.add("大连");
        ArrayList<String> select = new ArrayList<>();//存放选择的广播站
        while (!allArea.isEmpty()) {//只要仍有未覆盖地区
            String maxBroadcast = null;//覆盖最多未覆盖地区的广播
            int maxCount = 0;//覆盖最多未覆盖地区数
            for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {//遍历所有广播站，找覆盖最多未覆盖地区的广播
                HashSet<String> areas = entry.getValue();
                int count = 0;
                for (String area : areas) {//分别得到每个广播站覆盖的未覆盖地区数
                    if (allArea.contains(area)) {
                        count++;
                    }
                }
                if (count > maxCount) {//记录最大值
                    maxCount = count;
                    maxBroadcast = entry.getKey();
                }
            }
            select.add(maxBroadcast);//选择覆盖最多未覆盖地区的广播站
            allArea.removeAll(broadcasts.get(maxBroadcast));//将已经覆盖的地区移除
        }
        System.out.println(select);
    }
}
