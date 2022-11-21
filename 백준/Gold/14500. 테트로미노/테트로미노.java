import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
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
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit[i][j]=true;
				dfs(i,j,1,map[i][j]);
				visit[i][j]=false;
			}
		}
		
		System.out.println(max);

	}
	public static void dfs(int x, int y, int depth,int sum) {
		
		if(depth==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				if(!visit[nx][ny]) {
					visit[nx][ny]=true;
					dfs(nx,ny,depth+1,sum+map[nx][ny]);
					visit[nx][ny]=false;
				}
				if(!visit[nx][ny]&&depth==2) {
					visit[nx][ny]=true;
					dfs(x,y,depth+1,sum+map[nx][ny]);
					visit[nx][ny]=false;
				}
			}
			
		}
		
		
	}

}