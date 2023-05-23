
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
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[1]=arr[1];
		for(int i=2;i<=n;i++) {
			for(int j=i-1;j>=1;j--) {
				if(i%j==0) {
					dp[i]=Math.max(dp[i], Math.max(arr[i], dp[j]*(i/j)));
				}else {
					dp[i]=Math.max(dp[i], Math.max(arr[i], dp[j]+dp[i%j]));
				}
			}
		}
		System.out.println(dp[n]);
	}

}
