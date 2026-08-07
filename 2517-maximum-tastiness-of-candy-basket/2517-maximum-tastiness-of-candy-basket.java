class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n=price.length;
        Arrays.sort(price);
        int l=1;
        int r=Arrays.stream(price).max().getAsInt()-Arrays.stream(price).min().getAsInt();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(price, k , mid ) < k){
                r=mid-1;
            }
            else{
                ans=mid;
                l=mid+1;
            }
        }

        return ans;
    }

    private int possible(int[] price, int k , int tasty){
        int n=price.length;
        int candy=1;
        int last=price[0];
        for(int i=1;i<n;i++){
          if(price[i]-last >=tasty){
            candy++;
            last=price[i];
          }
        }
        return candy;
    }
}