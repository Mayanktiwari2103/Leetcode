class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=nums[i];
            }
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }

        }
        return max;
    }
}