class Solution {

    public int find(int[] piles, int hours){
        int n=piles.length;
        int totalhours=0;
        for(int i=0;i<n;i++){
            totalhours+=Math.ceil((double)piles[i]/(double)hours);
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int totalH=find(piles,mid);
            if(totalH<=h){
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