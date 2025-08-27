class Solution {
    public void generate(List<List<Integer>> result,int[] nums,int start, List<Integer> list){
        result.add(new ArrayList<>(list));//add current subset
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            generate(result,nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(result,nums,0,new ArrayList<>());
        return result;
    }
}