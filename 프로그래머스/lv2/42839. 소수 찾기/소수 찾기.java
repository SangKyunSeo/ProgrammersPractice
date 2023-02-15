import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static boolean visit[];
    static Set<Integer> set = new HashSet<>();
    static char ch[];
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        ch = new char[numbers.length()];
        
        
        
        Arrays.fill(visit,false);
        Arrays.fill(ch,'-');
        dfs(0,numbers);    
        System.out.println(set.toString());
        answer = set.size();
        return answer;
    }
    public static void dfs(int idx,String numbers){
        if(idx==numbers.length()){
            return;
        }
        for(int i=0;i<visit.length;i++){
            if(!visit[i]){
                visit[i]=true;
                ch[idx]=numbers.charAt(i);
                find(ch);
                dfs(idx+1,numbers);
                visit[i]=false;
                ch[idx]='-';
            }
        }
    }
    public static void find(char[] ch){
        sb = new StringBuilder();
        
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='-')sb.append(ch[i]);
        }
        
        int num = Integer.parseInt(sb.toString());
        boolean flag = false;
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num % i ==0)flag = true;
        }
        
        if(!flag && num!=0 && num!=1)set.add(num);
        if(num==2)set.add(num);
    }
}