
/*
 * 뱀과 사다리 게임
 */

import java.io.*;
import java.util.*;
class point{
	int x,cnt;
	point(int x,int cnt){
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	
	static int n,m;
	static boolean[] visit = new boolean[101];
	static ArrayList<Integer>[] list;
	static int[] dice = {1,2,3,4,5,6};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[101];
		for(int i=1;i<=100;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n+m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		bfs(1,0);
		System.out.println(min);
	}
	public static void bfs(int x,int cnt) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,cnt));
		visit[x]=true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x==100) {
				min = Math.min(p.cnt, min);
				return;
			}
			
			for(int i=0;i<6;i++) {
				int dx = p.x + dice[i];
				if(dx>100)continue;
				try {
					dx = list[dx].get(0);
				}catch(Exception e) {
					dx = p.x + dice[i];
				}
				
				if(!visit[dx]&&dx<=100) {
					visit[dx]=true;
					
					q.offer(new point(dx,p.cnt+1));
				}
			}
		}
		return;
		
	}

}
