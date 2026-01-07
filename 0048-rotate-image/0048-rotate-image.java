class Solution {
    public void reverse(int[][] matrix, int col) {
        int l=0;
        int r=matrix.length-1;
        while (l < r) {
            int temp = matrix[l][col];
            matrix[l][col] = matrix[r][col];
            matrix[r][col] = temp;
            l++;
            r--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            reverse(matrix,j);

        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }
}