class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int area=0;
        int maxarea=0;
        while(l<r){
            int length=Math.min(height[l],height[r]);
            int width=(r-l);
            area=length*width;
            maxarea=Math.max(area,maxarea);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxarea;
    }
}