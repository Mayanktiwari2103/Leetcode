class Solution {
    public int longestConsecutive(int[] nums) {
       int n=nums.length;
       HashSet<Integer> set=new HashSet<>();

       for(int num:nums){
        set.add(num);
       }
       int cnt=0;
       int maxcnt=0;
       for(int num:set){
        if(!set.contains(num-1)){
            cnt=1;
            int x=num;
            while(set.contains(x+1)){
                cnt++;
                x=x+1;
            }
            maxcnt=Math.max(cnt,maxcnt);
        }
       }
       return maxcnt;
    }
}