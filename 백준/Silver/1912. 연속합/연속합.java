
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		int arr[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1]=arr[1];
		
		for(int i=2;i<=n;i++) {
			if(dp[i-1]+arr[i]>arr[i])dp[i] = dp[i-1] + arr[i];
			else 
				dp[i]=arr[i];
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
		

	}

}
