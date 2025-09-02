class Solution {
    public void generate(List<List<String>> ls,char[][] board,int n,int row){
        //base case
        if(row==n){
           List<String> ans=new ArrayList<>();
           for(int i=0;i<n;i++){
            ans.add(new String(board[i]));
           }
           ls.add(ans);
           return;
        }
        for(int col=0;col<n;col++){
            if(issafe(board,n,row,col)){
                board[row][col]='Q';
                generate(ls,board,n,row+1);
                board[row][col] = '.';  
            }
        }
     
    }
    public boolean issafe(char[][] board,int n,int row,int col){
        //horizontal
        for(int j=0;j<col;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        //vertical
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //upper-left-diagonal(bcoz we are placing row by row , so no need to check down diagonals)
        for(int i=row, j=col;i>=0 &&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //upper-right-diagonal
        for(int i=row, j=col;i>=0 &&j<n;i--,j++){
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