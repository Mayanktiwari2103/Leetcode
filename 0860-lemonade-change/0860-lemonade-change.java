class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                cnt1++;
            }
            else if(bills[i]==10){
                if(cnt1==0){
                    return false;
                }
                else{
                    cnt1--;
                }
                cnt2++;

            }
            else{
                if(cnt1>=1 && cnt2>=1){
                    cnt1--;
                    cnt2--;

                }
                else if(cnt1>=3){
                    cnt1-=3;
                }
                else{
                    return false;
                }
                cnt3++;
            }
        }
        return true;
    }
}