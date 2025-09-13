class Solution {
    public void generate(List<List<String>> ls,char[][] board,int n,int row){
        if(row==n){
            List<String> list=new ArrayList<>();
            for(char[]r:board){
                list.add(new String(r));
            }
            ls.add(list);
            return;
        }

        for(int col=0;col<n;col++){
            if(issafe(board,n,row,col)){
                board[row][col]='Q';
                generate(ls,board,n,row+1);
                board[row][col]='.';

            }
        }
    }
    public boolean issafe(char[][] board,int n,int row,int col){
        //it should be not in same col 
        for(int j=0;j<row;j++){
            if(board[j][col]=='Q'){
                return false;
            }

        }
        //it should not be in left-upper diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //it should not be in right-upper diagonal
         for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ls=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');

        }
        generate(ls,board,n,0);
        return ls;

    }
}