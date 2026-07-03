public class Maze {
    public static void main(String[] args) {
        //迷宫
        int[][] map = new int[8][7];
        //1表示墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        System.out.println("迷宫的样子如下：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        findWay(map, 1, 1);
        System.out.println("寻路过程如下：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map:地图
     * @param i：当前坐标
     * @param j：当前坐标 若到达了map[6][5],表示找到了通路
     *               map[i][j]=0表示该点没有走过，1表示墙，2表示通路可以走，3表示已经走过但走不通
     *               策略：下->右->上->左
     * @return
     */
    public static boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//如果终点已经被走过，说明找到了通路
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前坐标未走过
                map[i][j] = 2;//标记当前点位已走过并假设可以走通
                if (findWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (findWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (findWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (findWay(map, i, j - 1)) {//向左走
                    return true;
                } else {//如果四个方向都不能走通，则当前坐标无法到达终点
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j]不等于0，也就是走到了墙（1）、已走过的路（2）或不可达的坐标（3）
                return false;
            }
        }
    }
}
