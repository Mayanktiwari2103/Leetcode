class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] vis=new int[n][m];
        vis[0][0]=1;
        int r=0;
        int c=0;
        
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(true){
            char ch=grid[r][c];
            int nr=r;
            int nc=c;

            if(ch=='U') nr--;
            if(ch=='R') nc++;
            if(ch=='D') nr++;
            if(ch=='L') nc--;

            if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc]==1){
                break;
            }
            
            vis[nr][nc]=1;
            r=nr;
            c=nc;

            
        }
        return new int[]{r,c};
        
        
    }
}