
/*
 * 연구소
 */
import java.io.*;
import java.util.*;

class point{
	int x,y;
	point(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{
	
	static int n,m;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
	}
	public static void dfs(int depth) {
		if(depth==3) {
			bfs();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(depth+1);
					map[i][j]=0;
				}
			}
		}
	}
	public static void bfs() {
		int[][] virus_map = new int[n][m];
		Queue<point> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virus_map[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus_map[i][j]==2) {
					q.add(new point(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(virus_map[nx][ny]==0) {
						virus_map[nx][ny]=2;
						q.add(new point(nx,ny));
					}
				}
			}
		}
		safe(virus_map);
	}
	public static void safe(int[][] virus_map) {
		int count = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus_map[i][j]==0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
		
	}

}
