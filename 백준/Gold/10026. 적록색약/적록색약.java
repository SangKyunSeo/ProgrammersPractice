
/*
 * 적록색약 - dfs bfs 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] map;
	static char[][] smap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int normal = 0;
	static int sormal = 0;
	static boolean[][] visit;
	static boolean[][] svisit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		smap = new char[n][n];
		visit = new boolean[n][n];
		svisit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = arr[j];
				smap[i][j] = arr[j];
				if(smap[i][j]=='G')
					smap[i][j]='R';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j]) {
					normal+=dfs(i,j);
				}
				
				if(!svisit[i][j]) {
					sormal+=sdfs(i,j);
				}
					
			}
		}
		
		System.out.println(normal+" "+sormal);
	}
	public static int dfs(int x, int y) {
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(!visit[nx][ny]&&map[nx][ny]==map[x][y]) {
					dfs(nx,ny);
				}
			}
		}
		return 1;
		
	}
	public static int sdfs(int x, int y) {
		svisit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(!svisit[nx][ny]&&smap[nx][ny]==smap[x][y]) {
					sdfs(nx,ny);
				}
			}
		}
		return 1;
		
	}

}
