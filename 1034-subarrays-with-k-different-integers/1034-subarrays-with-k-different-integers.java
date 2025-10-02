class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessthanequaltok(nums,k)-lessthanequaltok(nums,k-1);
    }
    private int lessthanequaltok(int[] nums,int k){
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0,r=0;
        int cnt=0;
        while(r<n){
            map.put(nums[r],r);
            while(map.size()>k){
                if(map.get(nums[l])==l){
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt=cnt+(r-l+1);       
            r++;
        }
        return cnt;
    }
}