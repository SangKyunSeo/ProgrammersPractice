
/*
 * 점프 점프 - 다이나믹 프로그래밍
 */
import java.util.*;
import java.io.*;

public class Main {

	static long[] dp;
	static int[] arr;
	static int n = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new long[1001];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i]=Integer.MAX_VALUE;
		}
		dp[1]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=arr[i];j++) {
				if((j+i)<=n) {
					dp[j+i] = Math.min(dp[i+j],dp[i]+1);
				}
			}
		}
		
		if(dp[n]>=Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(dp[n]);
		
	}
	

}
