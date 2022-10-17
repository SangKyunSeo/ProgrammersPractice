
/*
 * 수들의 합 2
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		while(true) {
		
			if(sum>=m) {
				sum-=arr[start++];
			}else if(end>=arr.length) {
				break;
			}
			else{
				sum+=arr[end++];
			}
			if(sum==m)cnt++;
		}
		System.out.println(cnt);
	}

}
