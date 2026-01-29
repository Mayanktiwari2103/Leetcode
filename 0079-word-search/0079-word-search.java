class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    boolean found=dfs(board,word,i,j,0);
                    if(found) return true;

                }
            }
        }
        return false;
    
        
    }
    public boolean dfs(char[][] board, String word, int r , int c ,int wi){
        int n=board.length;
        int m=board[0].length;
        // in this function false means backtrack and true means continue;
        //base case
        if(wi==word.length()) return true;

        //out of bound
        if(r<0 || r>=n || c<0 || c>=m){
            return false;
        }

        //invalid cases
        if(board[r][c]==' ' || board[r][c]!=word.charAt(wi)){
            return false;
        }
        char ch=board[r][c];
        board[r][c]=' ';
        if(dfs(board,word,r+1,c,wi+1)||
           dfs(board,word,r-1,c,wi+1)||
           dfs(board,word,r,c+1,wi+1)||
           dfs(board,word,r,c-1,wi+1))
        {
            return true;
        }
        //backtrack
        board[r][c]=ch;
        return false;

        
    }
}