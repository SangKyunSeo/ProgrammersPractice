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
		int sum = 0;
		int result = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<=n-k;i++) {
			sum = 0;
			for(int j=i;j<i+k;j++) {
				sum+=arr[j];
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
		

	}

}