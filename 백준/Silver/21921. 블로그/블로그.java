
/*
 * 블로그 
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n,x;
	static int visit[];
	static int max = 0;
	static int count = 0;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		visit= new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			visit[i]=Integer.parseInt(st.nextToken());
		}
		int a = 0;
		int b = 1;
		int sum = visit[a];
		while(b!=x) {
			sum += visit[b++];
			list.add(sum);
			if(max<sum)max=sum;
		}
		while(b!=n) {
			sum-=visit[a++];
			sum+=visit[b++];
			list.add(sum);
			if(max<sum)max=sum;
		}

		if(max!=0) {
			System.out.println(max);
			for(int i=0;i<list.size();i++) {
				if(list.get(i)==max)count++;
			}
			System.out.println(count);
		}else
			System.out.println("SAD");
		
	}

}
