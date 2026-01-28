class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(nums,result,new ArrayList<>(),0);
        return result;

    }
    public void generate(int[] nums,List<List<Integer>> result,List<Integer> list,int start){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            generate(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
    }
}