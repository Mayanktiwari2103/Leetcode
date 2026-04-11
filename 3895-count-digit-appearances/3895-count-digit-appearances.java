class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n=nums.length;
        int cnt=0;
        char target=(char)(digit+'0');
        for(int i=0;i<n;i++){
          int num=nums[i];
          String str=String.valueOf(num);
          for(int j=0;j<str.length();j++){
            if(str.charAt(j)==target){
                cnt++;
            }
          }
        }
        return cnt;
    }
}