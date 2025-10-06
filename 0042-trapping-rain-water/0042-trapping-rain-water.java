class Solution {
   
    public int trap(int[] height) {
        int n=height.length;
        int leftmax=0,rightmax=0;
        int l=0;
        int r=n-1;
        int sum=0;
        while(l<r){
            leftmax=Math.max(leftmax,height[l]);
            rightmax=Math.max(rightmax,height[r]);
            if(leftmax < rightmax){
                sum+=leftmax-height[l];
                l++;
            }
            else{
                sum+=rightmax-height[r];
                r--;
            }
        }
        return sum;

    }
}