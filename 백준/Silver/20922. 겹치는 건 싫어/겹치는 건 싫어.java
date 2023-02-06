
/*
 * 겹치는 건 싫어
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,k;
	static int number[];
	static int visit[] = new int[100001];
	static int max = 0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
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
		int sum = 1;
		visit[number[a]]+=1;
		while(b!=n) {
			visit[number[b]]+=1;
			sum+=1;
			if(visit[number[b]]>k) {
				flag=true;
				while(visit[number[b]]>k) {
					visit[number[a]]-=1;
					sum-=1;
					a++;
				}
			
			}
			b++;
			max = Math.max(max, sum);
		}
		if(!flag) {
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
