
/*
 * 빙산
 */
import java.io.*;
import java.util.*;

class Point{
	int x,y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {

	static int n,m;
	static int map[][];
	static int copyMap[][];
	static boolean[][] visit;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int mountainCount = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);

	}
	public static void dfs(int depth) {
		
		melt();
		copy();

		visit = new boolean[n][m];
		mountainCount = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visit[i][j]&&map[i][j]!=0) {
					bfs(i,j);
					mountainCount++;
				}
			}
		}
		if(check()) {
			if(mountainCount>=2) {
				System.out.println(depth+1);
				return;
			}else {
				dfs(depth+1);
			}
		}else {
			System.out.println(0);
			return;
		}
		
	}
	public static void melt() {
		copyMap = new int[n][m];
		int count;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0) {
					count = 0;
					for(int k=0;k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx>=0&&ny>=0&&nx<n&&ny<m) {
							if(map[nx][ny]==0)count++;
						}
					}
					if(map[i][j]-count<0)copyMap[i][j]=0;
					else copyMap[i][j] = map[i][j] - count;
				}
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visit[x][y]=true;
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(map[nx][ny]!=0) {
						if(!visit[nx][ny]) {
							visit[nx][ny]=true;
							q.offer(new Point(nx,ny));
						}
					}
					
						
					
				}
			}
		}
	}
	public static void copy() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=copyMap[i][j];
			}
		}
	}
	public static boolean check() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0)return true;
			}
		}
		return false;
	}
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
	}

}
