
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
		
		for(int i=n;i>=1;i--) {
			dp[i]=1;
			for(int j=n;j>i;j--) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1)
					dp[i]=dp[j]+1;
			}
		}
		
		int max = -1;
		for(int i=1;i<=n;i++) {
			if(max<dp[i])max = dp[i];
		}
		System.out.println(max);

	}

}
