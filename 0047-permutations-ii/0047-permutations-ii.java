class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(nums,result,new ArrayList<>(),used);
        return result;

    }
    public void generate(int[] nums, List<List<Integer>> result,List<Integer> list,boolean used[]){
        if(list.size()==nums.length && !result.contains(list)){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            list.add(nums[i]);
            generate(nums,result,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}