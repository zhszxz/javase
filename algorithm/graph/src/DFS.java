import java.util.Scanner;

/**
 * 深度优先遍历：岛屿数量
 */

class DFS {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                    dfs(i, j, map);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i, int j, int[][] map) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != 1) {
            return;
        }
        map[i][j] = 2;
        for (int[] dir : dirs) {
            int k = i + dir[0];
            int l = j + dir[1];
            dfs(k, l, map);
        }
    }
}