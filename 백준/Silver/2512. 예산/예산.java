
/*
 * 예산
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int budget[];
	static int m;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		budget = new int[n];
		
		for(int i=0;i<n;i++) {
			budget[i]=Integer.parseInt(st.nextToken());
			max = Math.max(budget[i], max);
		}
		Arrays.sort(budget);
		
		m = Integer.parseInt(br.readLine());
		int left = 0;
		int right = max;
		
		while(left<=right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i=0;i<n;i++) {
				if(budget[i]>mid) sum+=mid;
				else sum+=budget[i];
			}

			if(sum<=m)left = mid + 1;
			else right = mid - 1;
		
		}
		
		System.out.println(right);
		
	}

}
