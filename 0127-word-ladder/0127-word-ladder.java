class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first , int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.poll();
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                char arr[]=word.toCharArray();
                for(char ch='a' ; ch<='z' ; ch++){
                    arr[i]=ch;
                     String newWord = new String(arr);
                    if(st.contains(newWord)){
                        q.add(new Pair(newWord,step+1));
                        st.remove(newWord);
                    }
                }
            }
        }
        return 0;

    }
    
}