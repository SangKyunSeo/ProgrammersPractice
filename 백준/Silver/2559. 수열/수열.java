
/*
 * 수열 - 구현
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n = 0;
	static int k = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int start = 0;
		int end = n-1;
		int r_sum = 0;
		int l_sum = 0;
		int result = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			r_sum = 0;
			l_sum = 0;
			for(int j =start;j<=start+k-1;j++) {
				r_sum+=arr[j];
			}
			
			for(int j=end;j>=end-k+1;j--) {
				l_sum+=arr[j];
			}
		
			result = Math.max(result, Math.max(r_sum, l_sum));
			if(start+k==n)break;
			if(end-k==0)break;
			start++;
			end--;
		}
		System.out.println(result);
	}

}

