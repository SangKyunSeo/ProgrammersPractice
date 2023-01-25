
/*
 * 특정 거리의 도시 찾기
 */
import java.io.*;
import java.util.*;

class point{
	int x,depth;
	point(int x,int depth){
		this.x=x;
		this.depth=depth;
	}
}
public class Main {

	static int n,m,k,x;
	static boolean visit[];
	static List<Integer> list[];
	static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			list[i]= new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		bfs();
		if(result.size()!=0) {
			Collections.sort(result);
			for(int i=0;i<result.size();i++) {
				System.out.println(result.get(i));
			}
		}else
			System.out.println(-1);
		
		
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,0));
		visit[x]=true;
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.depth==k) {
				result.add(p.x);
			}
			for(int i:list[p.x]) {
				if(!visit[i]) {
					visit[i]=true;
					q.offer(new point(i,p.depth+1));
				}
			}
		}
	}
	
	

}
