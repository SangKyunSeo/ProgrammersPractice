import java.util.*;

class Solution {
    static char[] ch = {'A','E','I','O','U'};
    static List<String> list = new ArrayList<>();
    static List<Character> comb = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs(0);
        answer = list.indexOf(word)+1;
        return answer;
    }
    public static void dfs(int depth){
        if(depth==5){
            return;
        }
        for(int i=0;i<5;i++){
            solve(ch[i]);
            dfs(depth+1);
            comb.remove(depth);
        }
    }
    public static void solve(char c){
        comb.add(c);
        list.add(arrToString());
    }
    public static String arrToString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<comb.size();i++){
            sb.append(comb.get(i));
        }
        return sb.toString();
    }
    
}