class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int l=1;
        int r=position[n-1]-position[0];
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(balls(position,mid) < m){
                r=mid-1;

            }
            else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans;
    }

    public int balls(int[] position, int force){
        int n=position.length;
        int cntball=1;
        int last=position[0];
        for(int i=1;i<n;i++){
            if(position[i]-last >= force){
                cntball++;
                last=position[i];
            }

        }
        return cntball;
    }
}