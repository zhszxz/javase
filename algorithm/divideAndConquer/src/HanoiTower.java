public class HanoiTower {
    private static int count;

    public static void main(String[] args) {
        HanoiTower(5, 'A', 'B', 'C');
        System.out.println(count);
    }

    /**
     * @param num:num层汉诺塔
     * @param A：汉诺塔开始时所在的位置
     * @param B：移动过程需要借助的柱子
     * @param C：汉诺塔需要移动到的柱子
     */
    public static void HanoiTower(int num, char A, char B, char C) {
        //若汉诺塔只有一层，直接从A移动到C
        if (num == 1) {
            System.out.println("1号盘：" + A + "->" + C);
            count++;
        } else {
            //否则将圆盘看作两部分：最下面的盘和上面所有盘
            //先将上面所有盘移动到B柱
            HanoiTower(num - 1, A, C, B);
            //再将最下面的盘移动到C柱
            System.out.println(num + "号盘：" + A + "->" + C);
            count++;
            //最后将上面所有盘从B柱移动到C柱
            HanoiTower(num - 1, B, A, C);
        }
    }
}
