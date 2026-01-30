class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] mat=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],'.');
        }
        generate(mat,0,n,result);
        return result;
    }

    public boolean issafe(char mat[][], int row, int col, int n) {
        //column
        for (int i = 0; i < row; i++) {
            if (mat[i][col] == 'Q')
                return false;
        }
        //upper-diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (mat[i][j] == 'Q')
                return false;

        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public void generate(char mat[][], int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                temp.add(new String(mat[i]));
            }
            result.add(temp);

        }
        for (int col = 0; col < n; col++) {
            if (issafe(mat,row, col,n)) {
                mat[row][col] = 'Q';
                generate(mat, row+1, n, result);
                mat[row][col] = '.';
            }
        }

    }
}