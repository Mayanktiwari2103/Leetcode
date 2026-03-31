class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int l=1;
        int r=Arrays.stream(candies).max().getAsInt();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(kids(candies,mid) < k){
                r=mid-1;
            }
            else{
                ans=mid;
                l=mid+1;
            }

        }
        return ans;
    }

    public long kids(int[] candies, int candy){
        int n=candies.length;
        long children=0;
        for(int i=0;i<n;i++){
            children+=candies[i]/candy;
        }
        return children;
    }
}