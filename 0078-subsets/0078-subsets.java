class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      int n=nums.length;
      List<List<Integer>> ls=new ArrayList<>();
      generate(nums,ls,0,new ArrayList<>());
      return ls;

    }

    private void generate(int[] nums,List<List<Integer>> ls,int ind, List<Integer> list){
        ls.add(new ArrayList<>(list));

        for(int i=ind;i<nums.length;i++){
            list.add(nums[i]);
            generate(nums,ls,i+1,list);
            list.remove(list.size()-1);
        }
    }
   
}