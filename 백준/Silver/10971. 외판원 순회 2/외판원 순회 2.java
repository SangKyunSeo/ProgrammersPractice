
/*
 * 외판원 순회2
 * 
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] w;
	static int[][] dp;
	static int finish;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		finish = (1<<n) - 1;
		dp = new int[n][finish];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i],-1);
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(tsp(0,1)==987654321)System.out.println(0);
		else System.out.println(tsp(0,1));
		
	}
	public static int tsp(int start, int visit) {
		if(visit == finish) {
			if(w[start][0]==0)return 987654321;
			else return w[start][0];
		}
		
		if(dp[start][visit]!=-1)return dp[start][visit];
		
		dp[start][visit]=987654321;
		
		for(int i=0;i<n;i++) {
			int next = visit | (1<<i);
			
			if(w[start][i]==0||(visit&(1<<i))!=0)continue;
			
			dp[start][visit]= Math.min(dp[start][visit], tsp(i,next) + w[start][i]);
		}
		
		return dp[start][visit];
	}

}
