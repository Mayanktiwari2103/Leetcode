class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        generate(nums , ls , 0, new ArrayList<>());
        return ls;
    }

    private void generate(int[] nums,List<List<Integer>> ls, int ind, List<Integer> list ){
        if(list.size()==nums.length){
            ls.add(new ArrayList<>(list));
            return;
        }
         
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            generate(nums,ls,i+1,list);
            list.remove(list.size()-1);
        }

    }
    
}