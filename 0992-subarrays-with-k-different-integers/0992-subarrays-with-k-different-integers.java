class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int nums[] ,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
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
            cnt+=(r-l+1);
            r++;
        }
        return cnt;

    }
}