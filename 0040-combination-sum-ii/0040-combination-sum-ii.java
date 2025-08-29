class Solution {
    public void generate(List<List<Integer>> ls,int[] candidates,int target,List<Integer> list,int start,int sum){
        int n=candidates.length;
         if(sum==target){
            ls.add(new ArrayList<>(list));
            return;
        }
        if(sum>target) return;
       
        for(int i=start;i<n;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            generate(ls,candidates,target,list,i+1,sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls=new ArrayList<>();
        generate(ls,candidates,target,new ArrayList<>(),0,0);
        return ls;
    }
}