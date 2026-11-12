class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int[] inc=new int[n];
        int[] dec=new int[n];

        inc[0]=1;
        dec[0]=1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                inc[i]=inc[i-1]+1;
            }
            else{
                inc[i]=1;
            }
        }

        for(int i=1;i<n;i++){
            if(nums[i] < nums[i-1]){
                dec[i]=dec[i-1]+1;
            }
            else{
                dec[i]=1;
            }
        }

        int incmax=Arrays.stream(inc).max().getAsInt();
        int decmax=Arrays.stream(dec).max().getAsInt();
        return Math.max(incmax,decmax);
    }
}