
/*
 * 알고스팟
 */
import java.io.*;
import java.util.*;
class point implements Comparable<point>{
	int x;
	int y;
	int cnt;
	point(int x,int y,int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	public int compareTo(point p) {
		return cnt - p.cnt;
	}
}

public class Main {
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n,m;
	static boolean visit[][];
	static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visit = new boolean[m+1][n+1];
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=Character.getNumericValue(s.charAt(j));
			}
		}
		
		bfs(0,0);
		System.out.println(answer);
		
	}
	public static void bfs(int x,int y) {
		PriorityQueue<point> p = new PriorityQueue<>();
		
		p.offer(new point(x,y,0));
		visit[x][y]=true;
		while(!p.isEmpty()) {
			point pt = p.poll();
			
			if(pt.x==m-1&&pt.y==n-1) {
				answer =  pt.cnt;
				return;
			}
			
			for(int i =0;i<4;i++) {
				int nx = pt.x + dx[i];
				int ny = pt.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(!visit[nx][ny]&&map[nx][ny]==1) {
						visit[nx][ny]=true;
						p.offer(new point(nx,ny,pt.cnt+1));
					}
					if(!visit[nx][ny]&&map[nx][ny]==0) {
						visit[nx][ny]=true;
						p.offer(new point(nx,ny,pt.cnt));
					}
				}
			}
		}
		return;
	}
	

}
