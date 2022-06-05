package chapter02;

// 二维子矩阵的数字之和
public class Meet13 {

    public static void main(String[] args) {
        int[][] nums = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix matrix = new NumMatrix(nums);
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
    }

    private static class NumMatrix {

        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                int rowSum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    rowSum += matrix[i][j];
                    sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1]
                + sums[row1][col1];
        }
    }
}
