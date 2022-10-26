
/*
 * 데스나이트
 */
import java.io.*;
import java.util.*;

class point{
	int x,y,cnt;
	point(int x,int y,int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {

	static int n;
	static boolean[][] visit;
	static int r1,r2,c1,c2;
	static int[] dx = {-2,-2,0,0,2,2};
	static int[] dy = {-1,1,-2,2,-1,1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		visit = new boolean[n][n];
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		bfs(r1,c1,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(min);
		}
	}
	public static void bfs(int x,int y,int cnt) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,y,cnt));
		visit[x][y]=true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			if(p.x == r2&&p.y==c2) {
				min = Math.min(min, p.cnt);
				return;
			}
			
			for(int i=0;i<6;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(!visit[nx][ny]) {
						q.offer(new point(nx,ny,p.cnt+1));
						visit[nx][ny]=true;
					}
				}
				
			}
		}
		return;
		
	}

}
