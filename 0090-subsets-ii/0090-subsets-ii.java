class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        generate(nums,result,new ArrayList<>(),0);
        return result;
    }
    public void generate(int[] nums,List<List<Integer>> result,List<Integer> list, int start ){
        result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i-1]==nums[i]) continue;
            list.add(nums[i]);
            generate(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
    }
}