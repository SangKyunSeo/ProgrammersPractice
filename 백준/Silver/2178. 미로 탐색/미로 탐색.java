/*
 * 미로탐색
 */
import java.util.*;
import java.io.*;

class point{
	int x,y,cnt;
	point(int x ,int y,int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt = 0;
	static int min = Integer.MAX_VALUE;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n+1][m+1];
		
		for(int i =0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		bfs(0,0,1);
		System.out.println(min);
	}
	public static void bfs(int x,int y,int cnt) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,y,cnt));
		visit[x][y]=true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx==n-1&&ny==m-1) {
					min = Math.min(min, p.cnt+1);
					return;
				}
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visit[nx][ny]&&map[nx][ny]==1) {
						visit[nx][ny]=true;
						q.offer(new point(nx,ny,p.cnt+1));
					}
				}
				
			}
		}
	}
}
