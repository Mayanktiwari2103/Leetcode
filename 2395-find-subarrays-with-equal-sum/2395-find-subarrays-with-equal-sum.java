class Solution {
    public boolean findSubarrays(int[] nums) {
        int n=nums.length;
        int sum=0;
        if(n==2) return false;
        HashSet<Integer> st=new HashSet<>();
        int len=0;
        for(int i=0;i<n;i++){
           if(len<2){
            len++;
            sum+=nums[i];
           }
           if(len==2){
             if(st.contains(sum)) return true;
             st.add(sum);
             sum=nums[i];
             len=1;
           }
        }
        return false;
    }
}