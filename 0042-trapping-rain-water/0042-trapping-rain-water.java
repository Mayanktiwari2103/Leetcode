class Solution {
    public int trap(int[] height) {
       int n=height.length;
       int l=0;
       int r=n-1;
       int sum=0;
       int leftmax=0;
       int rightmax=0;
       while(l<r){
         if(height[l] <= height[r]){
            leftmax=Math.max(leftmax,height[l]);
            sum+=leftmax-height[l];
             l++;
         }
         else{
            rightmax=Math.max(rightmax,height[r]);
            sum+=rightmax-height[r];
             r--;
         }
        
       }
       return sum;
    }
}