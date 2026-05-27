class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m==0) return 0;
        if(n==1) return m;
        int l=1;
        int r=m;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(Math.pow(mid,n)==m){
                return mid;
            }
            else if(Math.pow(mid,m) > m){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
        
    }
}