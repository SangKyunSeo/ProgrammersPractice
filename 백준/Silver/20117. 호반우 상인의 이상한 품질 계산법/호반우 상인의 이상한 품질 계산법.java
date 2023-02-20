
/*
 * 호반우 상인의 이상한 품질 계산법
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int arr[];
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(n%2==0) {
			for(int i=n-1;i>=n/2;i--) {
				sum+=arr[i]*2;
			}
		}else {
			for(int i=n-1;i>=n/2+1;i--) {
				sum+=arr[i]*2;
			}
			sum+=arr[n/2];
		}
		
		System.out.println(sum);
	}

}
