//动态规划算法案例：背包问题
//有一容量有限的背包和若干种物品，每种物品有其质量和价值，问在不超过背包容量的前提下，背包中物品的价值最大是多少（每种物品限一件）
public class BackpackProblem {
    //现有一背包容积为4，有三种物品：吉他、音响、电脑，质量分别为1、4、3，价值分别为1500、3000、2000
    public static void main(String[] args) {
        int capacity = 4;//背包的容量
        int n = 3;//物品的种类数
        int[] weight = {1, 4, 3};//物品的质量
        int[] value = {1500, 3000, 2000};//物品的价值
        int[][] totalValue = new int[n + 1][capacity + 1];//totalValue[i][j]:在有i种物品，背包容量为j的情况下，背包中物品的最大价值
        for (int i = 0; i < n + 1; i++) {//背包容量为0时，背包中物品的最大价值只能为0
            totalValue[i][0] = 0;
        }
        for (int i = 0; i < capacity + 1; i++) {//物品种类为0时，背包中物品的最大价值只能为0
            totalValue[0][i] = 0;
        }
        for (int i = 1; i < totalValue.length; i++) {
            for (int j = 1; j < totalValue[0].length; j++) {
                if (weight[i - 1] > j) {//如果新增物品质量大于当前背包容量，则不可能放入背包,原来的放法仍是最优解
                    totalValue[i][j] = totalValue[i - 1][j];
                } else {//背包能放下新增物品
                    //取原来放法和放新物品价值的较大者
                    totalValue[i][j] = Math.max(totalValue[i - 1][j], value[i - 1] + totalValue[i - 1][j - weight[i - 1]]);
                }
            }
        }
        for (int i = 0; i < totalValue.length; i++) {
            for (int j = 0; j < totalValue[0].length; j++) {
                System.out.print(totalValue[i][j] + " ");
            }
            System.out.println();
        }
    }
}
