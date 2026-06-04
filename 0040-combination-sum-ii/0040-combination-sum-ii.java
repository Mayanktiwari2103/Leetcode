class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
       List<List<Integer>> ls=new ArrayList<>();
       generate(candidates, target , ls, new ArrayList<>(), 0,0);
       return ls;
    }

    private void generate(int[] candidates, int target,List<List<Integer>> ls, List<Integer> list, int sum , int ind ){
        if(sum> target) return;
        if(sum==target){
            ls.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            generate(candidates,target, ls, list,sum+candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
    
}