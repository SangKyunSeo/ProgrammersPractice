
/*
 * 징검 다리 건너기 (Large)
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static long bridge[];
	static long dp[];
	static long min = 0;
	static long max = 0;
	static long mid = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		bridge = new long[n];
		dp = new long[n];
		for(int i=0;i<n;i++) {
			bridge[i]=Integer.parseInt(st.nextToken());
			dp[i]=-1;
		}
		
		System.out.println(solve(0));
	}
	public static long solve(int x) {
		if(x==n-1)return 0;
		
		if(dp[x]!=-1)return dp[x];
		
		dp[x]=Long.MAX_VALUE;
		
		for(int i=x+1;i<n;i++) {
			dp[x]=Math.min(dp[x],Math.max(solve(i),(i-x)*(1+Math.abs(bridge[i]-bridge[x]))));
		}
		return dp[x];
	}
	

}
