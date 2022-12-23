
/*
 * 랜선 자르기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int k,n;
	static int[] arr;
	static long min = 0;
	static long max = 0;
	static long mid = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[k];
		
		for(int i=0;i<k;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(max<arr[i])max=arr[i];
		}
		max+=1;
		while(min<max) {
			mid = (max+min)/2;
			long count = 0;
			
			for(int i=0;i<k;i++) {
				count+=arr[i]/mid;
			}
			
			if(count<n) {
				max=mid;
			}else
				min=mid+1;
		}
		System.out.println(min-1);
		
	}

}

