class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
           sum+=nums[i];
           int rem = ((sum % k) + k) % k;
           if(map.containsKey(rem)){
            cnt+=map.get(rem);
            map.put(rem,map.get(rem)+1);
           }
           else{
            map.put(rem,1);
           }
        }
        return cnt;
    }
}