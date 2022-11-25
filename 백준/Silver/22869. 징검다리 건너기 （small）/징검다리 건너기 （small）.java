
/*
 * 징검 다리 건너기 small - dp
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n,k;
	static int[] arr;
	static boolean[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		dp = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp(1);
		
		if(dp[n])System.out.println("YES");
		else System.out.println("NO");
	}
	public static void dp(int index) {
		if(index==n) {
			dp[index]=true;
			return;
		}
		
		if(dp[index]==true) {
			return;
		}
		
		dp[index]=true;
		for(int i=index+1;i<=n;i++) {
			if((i-index)*(1 + Math.abs(arr[i]-arr[index]))<=k) {
				dp(i);
			}
		}
	}

}
