public class Palouti {
    //小明喜欢爬楼梯，他有时一次爬一阶，有时一次爬两阶，有时一次爬三阶，问20层楼梯，有多少种爬法
    public static void main(String[] args) {
        System.out.println(geyCount(20));
    }

    private static int geyCount(int jieshu) {
        if(jieshu==1){
            return 1;
        }
        if(jieshu==2){
            return 2;
        }
        if (jieshu==3){
            return 4;
        }
        return geyCount(jieshu-1)+geyCount(jieshu-2)+geyCount(jieshu-3);
    }
}
