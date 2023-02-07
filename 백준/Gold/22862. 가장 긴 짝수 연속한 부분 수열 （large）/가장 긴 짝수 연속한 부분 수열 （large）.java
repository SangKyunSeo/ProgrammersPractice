
/*
 * 가장 긴 짝수 연속한 부분 수열(large)
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n,k;
	static int number[];
	static Queue<Integer> q = new LinkedList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		number = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 1;
		int count = 0;
		if(number[a]%2==0)q.offer(number[a]);
		else {a++;}
		
		while(b<n) {
			if(number[b]%2==0)q.offer(number[b]);
			else count++;
			
			if(count>k) {
				max = Math.max(max, q.size());
				while(a<n) {
					
					if(number[a]%2==1) {
						a++;
						break;
					}else {
						q.poll();
						a++;
					}
				}
				count--;
			}
			b++;
		}
		max = Math.max(max, q.size());
		System.out.println(max);

	}

}
