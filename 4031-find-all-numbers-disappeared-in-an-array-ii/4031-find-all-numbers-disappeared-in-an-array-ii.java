class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ls=new ArrayList<>();
        HashSet<Integer> st=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        
        int start=0;
        int end=0;
        boolean flag=false;
        for(int i=lower;i<=upper;i++){
          if(!st.contains(i)){
            if(flag==false){
                start=i;
                end=i;
                flag=true;
            }
            else{
                end=i;
            }
          }
          else if(flag) {
            ls.add(Arrays.asList(start,end));
            flag=false;
          }

        }

        if(flag){
            ls.add(Arrays.asList(start,end));
        }

        return ls;
    }
}