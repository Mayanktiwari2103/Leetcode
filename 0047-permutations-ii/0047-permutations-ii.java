class Solution {
    public void generate(List<List<Integer>> result, int[] nums, List<Integer> list, boolean[] taken){
        int n = nums.length;

        if(list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<n;i++){
            if(taken[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !taken[i-1]) continue;
            
            list.add(nums[i]);
            taken[i] = true;

            generate(result, nums, list, taken);

            list.remove(list.size()-1);
            taken[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sorting needed for duplicate check
        List<List<Integer>> result = new ArrayList<>();
        generate(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
}
