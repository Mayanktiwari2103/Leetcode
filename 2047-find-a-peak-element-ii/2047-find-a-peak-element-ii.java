class Solution {
    public int findmax(int[][] mat, int n ,int m, int col){
        int maxvalue=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>maxvalue){
                maxvalue=mat[i][col];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int maxrowind=findmax(mat,n,m,mid);
            int left=mid-1>=0 ? mat[maxrowind][mid-1] : -1;
            int right=mid+1<m ? mat[maxrowind][mid+1] : -1;
            if(mat[maxrowind][mid]> left && mat[maxrowind][mid]> right){
                return new int[]{maxrowind,mid};
            }
            else if(mat[maxrowind][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};

        
    }
}