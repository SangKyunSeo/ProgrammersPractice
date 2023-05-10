
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i=0;i<n;i++) {
			arr[i+1] = Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		for(int i=2;i<=n;i++) {
			if(i>=3) {
				dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
			}else {
				dp[i] = Math.max(dp[i-2]+arr[i], arr[i-1]+arr[i]);
			}
		}
		
		System.out.println(dp[n]);

	}

}
