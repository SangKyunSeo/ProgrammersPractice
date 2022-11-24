
/*
 * 팰린드롬 만들기
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int arr[];
	static int dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1][n+1];
		arr = new int[n];
		for(int i=0;i<n+1;i++) {
			Arrays.fill(dp[i],-1);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp(0,n-1));
	}
	public static int dp(int left,int right) {
		if(left>=right) return 0;
		if(dp[left][right]!=-1)return dp[left][right];
		int min = 0;
		if(arr[left]==arr[right]) {
			min = dp(left+1,right-1);
		}
		else
			min = Math.min(dp(left+1,right)+1,dp(left,right-1)+1);
		
		return dp[left][right] = min;
	}

}
