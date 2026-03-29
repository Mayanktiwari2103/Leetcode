class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxprofit=0;
        int buy=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i] < buy){
                buy=prices[i];
            }
            if(prices[i] > buy){
                maxprofit=Math.max(maxprofit,prices[i]-buy);
            }

        }
        return maxprofit;
    }
}