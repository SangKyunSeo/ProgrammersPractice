
/*
 * 이분 그래프
 */
import java.util.*;
import java.io.*;

public class Main {

	static boolean visit[];
	static List<Integer> list[];
	static int[] color;
	static boolean checkgraph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<k;i++) {
			checkgraph = true;
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list = new ArrayList[v+1];
			visit = new boolean[v+1];
			color = new int[v+1];
			
			for(int j=1;j<v+1;j++) {
				list[j]=new ArrayList<>();
			}
			
			for(int j=0;j<e;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int j=1;j<v+1;j++) {
				if(checkgraph==false) {
					break;
				}
				
				if(!visit[j]) {
					bfs(j);
				}
				
			}
			
			if(checkgraph==false)
				System.out.println("NO");
			else
				System.out.println("YES");
			
		}
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		color[start] = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int i:list[node]) {
				if(!visit[i]) {
					visit[i]=true;
					q.offer(i);
					color[i]=color[node]*-1;
				}
				
				if(color[node]+color[i]!=0) {
					checkgraph = false;
					return;
				}
			}
			
		}
		
		
		
	}

}
