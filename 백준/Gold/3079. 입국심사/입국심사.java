
/*
 * 입국 심사
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int arr[];
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long left = 0;
		long right = max * m;
		long mid = 0;
		
		while(left<=right) {
			mid = (right + left) / 2;
			long sum = 0;
			for(int i=0;i<n;i++) {
				sum+=mid/arr[i];
				if(sum>=m)break;
			}
			if(sum<m) left=mid+1;
			else {
				right=mid-1;
				min=Math.min(min,mid);
			}
		}
		System.out.println(min);
		
	}

}
