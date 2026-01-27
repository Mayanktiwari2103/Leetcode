class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(nums,result,new ArrayList<>(),0);
        return result;
    }
    public void generate(int[] nums,List<List<Integer>> result,List<Integer> list,int start){
        int n=nums.length;
        result.add(new ArrayList<>(list));
        for(int i=start;i<n;i++){
            list.add(nums[i]);
            generate(nums,result,list,i+1);
            list.remove(list.size()-1);


        }
    }
}