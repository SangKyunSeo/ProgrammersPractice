
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[] = new int[n];
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[i]<dp[j]+1)
					dp[i]=dp[j]+1;
			}
		}
		int max = -1;
		for(int i=0;i<n;i++) {
			if(max<dp[i])max=dp[i];
		}
		
		System.out.println(max);
	}

}
