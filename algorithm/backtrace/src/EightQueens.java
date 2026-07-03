public class EightQueens {
    int[] array;//记录皇后们的位置，下标表示行，值表示列
    static int queenCount = 8;
    int count = 0;

    public EightQueens() {
        array = new int[queenCount];
    }

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.println("总共有" + queens.count + "种摆法");
    }

    //摆下第n个皇后
    private void check(int n) {
        if (n == queenCount) {//此时8个皇后已经全部摆下
            print();
            count++;
            return;
        }
        //将第n个皇后依次放在该行的第i个位置，判断是否冲突
        for (int i = 0; i < queenCount; i++) {
            array[n] = i;
            if (judge(n)) {//若不冲突，继续下一个皇后
                check(n + 1);
            }
            //若冲突，进入下一次循环，将皇后放在下一个位置
        }
    }

    //判断第n个摆下的皇后是否与前面n-1个皇后冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //是否在同一列或同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
