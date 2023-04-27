
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		for(int i=1;i<=n;i++) {
			dp[i]=arr[i];
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j])dp[i] = Math.max(arr[i]+dp[j], dp[i]);
			}
		}
		
		int max = -1;
		for(int i=1;i<=n;i++) {
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
	}

}
