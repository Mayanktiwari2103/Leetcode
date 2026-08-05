class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            st.add(nums1[i]);
        }

        for(int num:nums2){
            if(st.contains(num)){
                ans.add(num);
            }
        }

        int[] result=new int[ans.size()];
        int ind=0;
        for(int num: ans){
            result[ind++]=num;
        }
        
        return result;
    }
}