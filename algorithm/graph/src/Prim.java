import java.util.Arrays;
import java.util.Scanner;

/**
 * Prim算法：最小生成树
 */
class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            grid[s][t] = w;
            grid[t][s] = w;
        }
        int totalWeight = 0;
        boolean[] inTree = new boolean[n + 1];
        inTree[1] = true;
        int[] minDist = new int[n + 1];
        for (int i = 0; i < minDist.length; i++) {
            minDist[i] = grid[1][i];
        }
        int curNo = 1;
        for (int i = 0; i < n - 1; i++) {
            int minWeigth = Integer.MAX_VALUE;
            int minNode = 0;
            for (int j = 1; j < grid[curNo].length; j++) {
                if (!inTree[j] && minDist[j] < minWeigth) {
                    minWeigth = minDist[j];
                    minNode = j;
                }
            }
            totalWeight += minWeigth;
            curNo = minNode;
            inTree[minNode] = true;
            for (int j = 0; j < grid[curNo].length; j++) {
                minDist[j] = Math.min(minDist[j], grid[curNo][j]);
            }
        }
        System.out.println(totalWeight);
    }
}