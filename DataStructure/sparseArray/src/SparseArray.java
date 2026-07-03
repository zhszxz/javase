import java.io.*;
import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        Integer[][] arr = {
                {0, 0, 0, 0, 1},
                {0, 3, 0, 2, 0},
                {6, 7, 3, 0, 0},
                {5, 4, 8, 9, 0}};
        Integer[][] Sparse = TwoDimensionalToSparse(arr);
        BufferedWriter bw = new BufferedWriter(new FileWriter("sparse array\\resource\\data.txt"));
        for (Integer[] integers : Sparse) {
            String line = Arrays.toString(integers);
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        Integer[][] Array = SparseToTwoDimensional(Sparse);
        for (Integer[] integers : Array) {
            System.out.println(Arrays.toString(integers));
        }
    }

    //二维数组转稀疏数组
    public static Integer[][] TwoDimensionalToSparse(Integer[][] array) {
        int rowNum = array.length;
        int columnNum = array[0].length;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0)
                    count++;
            }
        }
        Integer[][] spares = new Integer[count + 1][3];
        spares[0][0] = rowNum;
        spares[0][1] = columnNum;
        spares[0][2] = count;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    k++;
                    spares[k][0] = i;
                    spares[k][1] = j;
                    spares[k][2] = array[i][j];
                }
            }
        }
        return spares;
    }

    //稀疏数组转二位数组
    public static Integer[][] SparseToTwoDimensional(Integer[][] sparse) {
        Integer array[][] = new Integer[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            Integer row = sparse[i][0];
            Integer column = sparse[i][1];
            Integer value = sparse[i][2];
            array[row][column] = value;
        }
        return array;
    }
}
