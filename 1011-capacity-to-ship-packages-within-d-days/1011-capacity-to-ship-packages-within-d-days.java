class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=Arrays.stream(weights).max().getAsInt();
        int r=Arrays.stream(weights).sum();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(capacity(weights,mid)<=days){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;


    }
    public int capacity(int[] weights, int cap){
        int n=weights.length;
        int sum=0;
        int day=1;
        for(int i=0;i<n;i++){
            sum+=weights[i];
            if(sum > cap){
                sum=weights[i];
                day++;
            }
        }
        return day;
    }
}