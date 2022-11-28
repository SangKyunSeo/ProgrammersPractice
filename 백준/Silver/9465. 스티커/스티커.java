
import java.util.*;
import java.io.*;

public class Main {
	static int t,n;
	static int[][] map;
	static int[][] dp;
	static int sum = 0;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		
		for(int test = 0;test<t;test++) {	
			n = Integer.parseInt(br.readLine());
			map = new int[2][n];
			dp = new int[2][n];
			sum = 0;
			max = Integer.MIN_VALUE;
			
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0]=map[0][0];
			dp[1][0]=map[1][0];
			
			if(n>1) {
				dp[0][1]=dp[1][0]+map[0][1];
				dp[1][1]=dp[0][0]+map[1][1];
				for(int i=2;i<n;i++) {
					dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + map[0][i];
					dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + map[1][i];
				}
			}
			
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
			
		}

	}

}
