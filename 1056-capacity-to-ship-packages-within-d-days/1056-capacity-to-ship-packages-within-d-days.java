class Solution {
    public int find(int[] weights, int maxcap){
        int n=weights.length;
        int total=0;
        int day=1;
        for(int i=0;i<n;i++){
            if(weights[i]+total>maxcap){
                day++;
                total=weights[i];
            }
            else{
               total+=weights[i];

            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int nofdays=find(weights,mid);
            if(nofdays<=days){
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }

        }
        return ans;
        
    }
}