

import java.util.*;
import java.io.*;

class point{
	int x;
	int y;
	point(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n,m;
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		int x = 0;
		int y = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					x = i;
					y = j;
				}
			}
		}
		bfs(x,y);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0) {
					map[i][j]-=2;
				}
			}
		}
		
		print();
	}
	public static void bfs(int x,int y) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(x,y));
		visit[x][y]=true;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visit[nx][ny] && map[nx][ny]!=0) {
						visit[nx][ny]=true;
						map[nx][ny]=map[p.x][p.y] + 1;
						q.offer(new point(nx,ny));
					}
					
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
