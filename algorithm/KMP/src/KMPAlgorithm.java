//KMP算法解决字符串匹配问题
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int index = KMP(str1, str2);
        System.out.println(index);
    }

    //利用KMP算法判断字符串str1是否包含str2，包含则返回str2在str1中的起始索引，否则返回-1
    public static int KMP(String haystack, String needle) {
        int[] next = getNext(needle);
        char[] str1Array = haystack.toCharArray();
        char[] str2Array = needle.toCharArray();
        int i = 0, j = 0;
        while (i < str1Array.length && j < str2Array.length) {
            if (str1Array[i] == str2Array[j]) {
                i++;
                j++;
            } else {//匹配不成功
                i = j == 0 ? i + 1 : i - next[j - 1];//i应该后移（已匹配的位数-最后一次成功匹配时对应的部分匹配值）
                j = 0;
            }
        }
        if (j == str2Array.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    //获取部分匹配值表，部分匹配值是指一个字符串最长公共前后缀长度，如对于“A”，部分匹配值为0，“AB”为0，“AA”为1，“ABAB”为2
    public static int[] getNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;//长度为1的字符串，部分匹配值为0（因为前缀后缀都是空集）
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //i指向当前字符串的末尾字符，j表示当前字符串的部分匹配值
            //也可以认为i指向公共后缀的末尾字符，j指向公共前缀的末尾字符
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {//当公共前后缀的下一个字符不相等则部分匹配值要回退
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {//当公共前后缀的下一个字符相等说明公共前后缀的长度也就是部分匹配值要加1
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
