class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }

        }
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(map.get(num)==0) continue;
            for(int j=0;j<k;j++){
                int temp=num+j;
                if(!map.containsKey(temp) || map.get(temp)==0){
                    return false;
                }
                map.put(temp,map.get(temp)-1);

            }
        }
        return true;
    }
}