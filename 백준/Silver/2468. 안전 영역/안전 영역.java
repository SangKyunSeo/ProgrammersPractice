
/*
 * 안전영역 - bfs
 */
import java.util.*;
import java.io.*;

class point{
	int x;
	int y;
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n = 0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean checkSafe = false;
	static int max = Integer.MIN_VALUE;
	static int count = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
	}
	public static void dfs(int rain) {
		if(count==0) {
			return;
		}
		
		count = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(!visit[i][j]&&map[i][j]>rain)
					bfs(i,j,rain);
			}
		}
		max = Math.max(max, count);
		visit = new boolean[n][n];
		dfs(rain+1);
	}
	public static void bfs(int x,int y,int rain) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			checkSafe = false;
			for(int i=0;i<4;i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(!visit[nx][ny]&&map[nx][ny]>rain) {
						visit[nx][ny] = true;
						checkSafe = true;
						q.offer(new point(nx,ny));
					}
				}
			}
			if(!checkSafe&&q.isEmpty()) {
				count++;
			}
			else if(checkSafe&&q.isEmpty()) {
				count++;
			}
		}
		
	}

}
