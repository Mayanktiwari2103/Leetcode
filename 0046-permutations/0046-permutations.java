class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ls=new ArrayList<>();
       generate(nums, ls,new ArrayList<>(), 0);
       return ls;
    }

    private void generate(int[] nums,List<List<Integer>> ls, List<Integer> list, int ind){
        if(list.size()==nums.length){
            ls.add(new ArrayList<>(list));
        }

        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            generate(nums,ls,list,i+1);
            list.remove(list.size()-1);
        }
    }

    
}