class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(hand[i])){
                map.put(hand[i],map.get(hand[i])+1);
            }
            else{
                map.put(hand[i],1);
            }
        }
        for(int i=0;i<n;i++){
            int curr=hand[i];
            if(map.get(hand[i])==0) continue;
            for(int j=0;j<groupSize;j++){
                int card=curr+j;
                if(!map.containsKey(card) || map.get(card)==0){
                    return false;
                }
                map.put(card,map.get(card)-1);
            }
        

        }
        return true;
    }
}