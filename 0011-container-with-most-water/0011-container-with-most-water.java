class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int area=0;
        int maxarea=0;
        int l=0,r=n-1;
        while(l<r){
           int heigh=Math.min(height[l],height[r]);
           int width=(r-l);
           area=heigh*width;
           if(height[l]<height[r]){
            l++;
           }
           else{
            r--;
           }
           
           maxarea=Math.max(maxarea,area);

        }
        return maxarea;
        
    }
}