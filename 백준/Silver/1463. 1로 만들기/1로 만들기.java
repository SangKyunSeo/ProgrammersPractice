import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			if(i%6==0)dp[i] = Math.min(dp[i-1],Math.min(dp[i/2], dp[i/3]))+1;
			else if(i%2==0)dp[i] = Math.min(dp[i-1], dp[i/2])+1;
			else if(i%3==0)dp[i] = Math.min(dp[i-1], dp[i/3])+1;
			else dp[i]=dp[i-1]+1;
		}
		System.out.println(dp[n]);
	}
	
}
