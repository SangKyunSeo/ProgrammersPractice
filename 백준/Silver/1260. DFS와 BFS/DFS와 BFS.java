import java.util.*;
import java.io.*;

public class Main {

	static int n,m,v;
	static int map[][];
	static boolean visit[];
	static List<Integer> dList = new ArrayList<>();
	static List<Integer> bList = new ArrayList<>();
	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b]=1;
			map[b][a]=1;
		}
		
		dfs(v);
		init();
		bfs();
		print(dList);
		System.out.println();
		print(bList);
	}
	public static void print(List<Integer> list) {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	public static void dfs(int v) {
		dList.add(v);
		visit[v]=true;
		s.add(v);
		while(!s.empty()) {
			int e = s.pop();
			for(int i=1;i<=n;i++) {
				if(map[e][i]==1) {
					if(!visit[i])
						dfs(i);
				}
			}
		}
	}
	public static void init() {
		for(int i=0;i<visit.length;i++) {
			visit[i]=false;
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visit[v]=true;
		q.add(v);
		while(!q.isEmpty()) {
			int e = q.poll();
			bList.add(e);
			for(int i=1;i<=n;i++) {
				if(map[e][i]==1) {
					if(!visit[i]) {
						q.offer(i);
						visit[i]=true;
					}
				}
			}
		}
	}

}
