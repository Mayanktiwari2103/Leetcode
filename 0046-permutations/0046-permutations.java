class Solution {
    public void generate(List<List<Integer>> result,int[] nums,List<Integer> list){
        int n=nums.length;
        if(list.size()==n){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            generate(result,nums,list);
            list.remove(list.size()-1);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(result,nums,new ArrayList<>());
        return result;
    }
}