class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1;
        int r=Arrays.stream(piles).max().getAsInt();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(findk(piles,mid)<=h){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
       
    }
    public int findk(int[] piles, int k){
        int sum=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double) piles[i]/k);

        }
        return sum;

    }
}