class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] flatten=new int[m*n];
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                flatten[ind++]=matrix[i][j];
            }
        }
        int length=flatten.length;
        int l=0;
        int r=length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(flatten[mid]==target) return true;
            else if(target<flatten[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}