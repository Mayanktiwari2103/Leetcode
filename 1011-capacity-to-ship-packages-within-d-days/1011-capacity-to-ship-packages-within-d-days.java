class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=Arrays.stream(weights).max().getAsInt();
        int r=Arrays.stream(weights).sum();
        while(l<=r){
            int mid=l+(r-l)/2;
            if(capacity(weights,mid)<=days){
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return l;
    }
    public int capacity(int[] weights,int k){
        int n=weights.length;
        int sum=0;
        int day=1;
        for(int i=0;i<n;i++){
            if(weights[i]+sum>k){
                day++;
                sum=weights[i];
            }
            else{
                sum+=weights[i];
            }
            


        }
        return day;
    }
}