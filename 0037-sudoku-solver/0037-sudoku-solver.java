class Solution {
    public boolean generate(char[][] board,int row,int col){
        if(row==9){
           return true;
        }
        int nextrow=row,nextcol=col+1;
        if(nextcol==9){
            nextrow=row+1;
            nextcol=0;

        }
        if(board[row][col]!='.'){
            return generate(board,nextrow,nextcol);
        }
        for(char digit='1';digit<='9';digit++){
            if(issafe(board,row,col,digit)){
                board[row][col]=digit;
                if(generate(board,nextrow,nextcol)) return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    public boolean issafe(char[][] board,int row, int col,char digit){
            for(int j=0;j<9;j++){
                if(board[row][j]==digit){
                    return false;
                }

            }            
            for(int j=0;j<9;j++){
                if(board[j][col]==digit){
                    return false;
                }

            }   
            int srow=(row/3)*3;
            int scol=(col/3)*3;
            for(int i=srow;i<=srow+2;i++){
                for(int j=scol;j<=scol+2;j++){
                    if(board[i][j]==digit){
                        return false;
                    }
                }
            }         
        
        return true;



    }
    public void solveSudoku(char[][] board) {
        generate(board,0,0);

    }
}