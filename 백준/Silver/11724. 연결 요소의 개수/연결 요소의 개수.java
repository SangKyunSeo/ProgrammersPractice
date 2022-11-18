
/*
 * 연결 요소의 개수
 */

import java.util.*;
import java.io.*;

public class Main {

	
	static List<Integer> list[];
	static boolean visit[];
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for(int i=1;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int start) {
		Stack<Integer> s = new Stack<>();
		visit[start]=true;
		s.push(start);
		
		while(!s.isEmpty()) {
			boolean check = false;
			int node = s.peek();
			for(int i:list[node]) {
				if(!visit[i]) {
					check = true;
					s.push(i);
					visit[i]=true;
					break;
				}
			}
			if(check==false) {
				s.pop();
			}
		}
	}

}
