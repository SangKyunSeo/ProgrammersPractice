
/*
 * 두 용액
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = arr.length-1;
		int a=0, b=0;
		
		while(start<end) {
			sum = arr[start]+arr[end];
			
			if(Math.abs(sum)<min) {
				min = Math.abs(sum);
				a = arr[start];
				b = arr[end];
			}
			
			if(sum==0)break;
			
			if(sum>0)end--;
			if(sum<0)start++;
			
			
		}
		
		System.out.println(a+" "+b);
		
		
	}
}
