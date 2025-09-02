class Solution {
    public boolean generate(char[][] board, String word, int i,int j,int start){
        int row=board.length;
        int col=board[0].length;
        //base case
        if(start==word.length()){
            return true;
        }
         //out of bound
        if(i<0 || j<0 || i>=row || j>=col){
            return false;
        }
        if(board[i][j]!=word.charAt(start)){
            return false;
        }
        //mark as visited
        char ch=board[i][j];
        board[i][j]='#';
        boolean found=generate(board,word,i,j+1,start+1) || 
                      generate(board,word,i+1,j,start+1) || 
                      generate(board,word,i-1,j,start+1) || 
                      generate(board,word,i,j-1,start+1);

        //restore again if not true;
        board[i][j]=ch;              
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(generate(board,word,i,j,0)){
                    return true;

                }


            }
        }
        return false;
        
    }
}