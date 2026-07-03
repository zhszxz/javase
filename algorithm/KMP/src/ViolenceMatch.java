//暴力解决字符串匹配问题
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int startIndex = violenceMatch(str1, str2);
        System.out.println(startIndex);
    }

    //判断字符串str1是否包含str2，包含则返回str2在str1中的起始索引，否则返回-1
    public static int violenceMatch(String str1, String str2) {
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        int i = 0, j = 0;
        while (i < str1Array.length && j < str2Array.length) {
            if (str1Array[i] == str2Array[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == str2Array.length ) {
            return i - j;
        } else {
            return -1;
        }
    }
}
