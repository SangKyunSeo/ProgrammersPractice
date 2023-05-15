import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static int INF = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;
        int dp[] = new int[3000001];
        Arrays.fill(dp,INF);
        dp[x] = 0;
        dp[x+n] = 1;
        dp[x*2] = 1;
        dp[x*3] = 1;
        
        for(int i=1;i<=y;i++){
            if(dp[i]!=INF){
                dp[i+n]=Math.min(dp[i]+1,dp[i+n]);
                dp[i*2]=Math.min(dp[i]+1,dp[i*2]);
                dp[i*3]=Math.min(dp[i]+1,dp[i*3]);
            }
        }
        answer = dp[y];
        if(answer==INF){
            return answer = -1;
        }else
            return answer;
    }
}