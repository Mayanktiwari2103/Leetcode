class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int l=1;
        int r=Arrays.stream(quantities).max().getAsInt();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(retail(quantities, mid) <= n){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;

    }

    public int retail(int[] quantities, int maxval){
        int m=quantities.length;
        int stores=0;
        for(int i=0;i<m;i++){
            stores+=Math.ceil((double) quantities[i]/maxval);
        }
        return stores;
    }
}