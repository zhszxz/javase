import java.util.Arrays;
import java.util.Scanner;

/**
 * 弗洛伊德算法：多源最短路径
 */
public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int[] each : grid) {
            Arrays.fill(each, 10005);
        }
        for (int i = 1; i < n + 1; i++) {
            grid[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            grid[v][u] = w;
            grid[u][v] = w;
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(grid[start][end] == 10005 ? -1 : grid[start][end]);
        }
    }
}
