class Solution {
    public void solveSudoku(char[][] board) {
        generate(board);
    }

    public boolean issafe(char[][] board, int row, int col,char ch) {
            for (int i= 0; i < 9; i++) {
                if (board[row][i] == ch)
                    return false;

            }
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == ch)
                    return false;
            }
            int sr=row-row%3;
            int sc=col-col%3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[sr+i][sc+j]==ch) return false;
                }
            }
           
        return true;
    }

    public boolean generate(char[][] board) {

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if (issafe(board,i,j,ch)) {
                            board[i][j] = ch;
                            if(generate(board)) return true;;
                            board[i][j] = '.';
                        }
                   
                    }
                    return false;

                }

            }
        }
        return true;
    }
}