class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ls=new ArrayList<>();
       generate(nums, ls, new ArrayList<>(),0);
       return ls;

    }

    private void generate(int[] nums, List<List<Integer>> ls , List<Integer> list, int ind){
        ls.add(new ArrayList<>(list));
        for(int i=ind;i<nums.length;i++){
            list.add(nums[i]);
            generate(nums,ls,list,i+1);
            list.remove(list.size()-1);
        }
    }
   
}