class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
       int l=0;
       int r=n-1;
       int maxarea=0;
       while(l<r){
         int length=Math.min(height[l],height[r]);
         int width=r-l;
         maxarea=Math.max(maxarea, length*width);

         if(height[l] < height[r]){
            l++;
         }
         else{
            r--;
         }
        }
        return maxarea;
    }
}