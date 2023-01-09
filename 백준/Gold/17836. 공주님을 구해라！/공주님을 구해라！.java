
/*
 * 공주님을 구해라!
 */
import java.util.*;
import java.io.*;

class point{
	int x,y,depth;
	boolean gram;
	point(int x,int y,int depth, boolean gram){
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.gram = gram;
	}
}
public class Main {

	static int n,m,t;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] svisit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] ddx = {1,0};
	static int[] ddy = {0,1};
	static Queue<point> q = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		svisit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println("Fail");
		}else if(min>t) {
			System.out.println("Fail");
		}else {
			System.out.println(min);
		}
		
		
	}
	public static void bfs(int x,int y,int depth) {
		q.offer(new point(x,y,depth,false));
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.gram==true) {
				if(p.depth>t)return;
				if(p.x==n-1&&p.y==m-1)return;
				for(int i=0;i<2;i++) {
					int nx = p.x + ddx[i];
					int ny = p.y + ddy[i];
					
					if(nx>=0&&ny>=0&&nx<n&&ny<m) {
						if(!svisit[nx][ny]) {
							svisit[nx][ny]=true;
							q.offer(new point(nx,ny,p.depth+1,true));
						}
						
					}
					
					if(nx==n-1&&ny==m-1) {
						min = Math.min(min, p.depth+1);
					}
				}
			}else {
				if(p.depth>t)return;
				if(p.x==n-1&&p.y==m-1)return;
				for(int i=0;i<4;i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(nx>=0&&ny>=0&&nx<n&&ny<m) {
						if(!visit[nx][ny]&&p.gram==false) {
							if(map[nx][ny]==2) {
								visit[nx][ny]=true;
								q.offer(new point(nx,ny,p.depth+1,true));
							}else if(map[nx][ny]==0){
								visit[nx][ny]=true;
								q.offer(new point(nx,ny,p.depth+1,false));
							}
						}
					}
					
					if(nx==n-1&&ny==m-1) {
						min = Math.min(min, p.depth+1);
					}
					
				}
			}
		}
		
	}



}

