
/*
 * 무기 공학
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int map[][];
	static boolean visit[][];
	static int result = Integer.MIN_VALUE;
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
		
		dfs(0,0);
		System.out.println(result);
	}
	public static void dfs(int idx,int sum) {
		if(idx==n*m) {
			result = Math.max(sum, result);
			return;
		}
		
		int row = idx/m;
		int col = idx%m;
		
		if(!visit[row][col]) {
			if(row+1<n && col+1<m && !visit[row+1][col] && !visit[row][col+1]) {
				visit[row][col]=true;
				visit[row+1][col]=true;
				visit[row][col+1]=true;
				dfs(idx+1,sum+map[row+1][col]+map[row][col+1]+(2*map[row][col]));
				visit[row][col]=false;
				visit[row+1][col]=false;
				visit[row][col+1]=false;
			}
			if(row+1<n && col-1>=0 && !visit[row+1][col] && !visit[row][col-1]) {
				visit[row][col]=true;
				visit[row+1][col]=true;
				visit[row][col-1]=true;
				dfs(idx+1,sum+map[row+1][col]+map[row][col-1]+(2*map[row][col]));
				visit[row][col]=false;
				visit[row+1][col]=false;
				visit[row][col-1]=false;
			}
			if(row-1>=0 && col+1<m && !visit[row-1][col] && !visit[row][col+1]) {
				visit[row][col]=true;
				visit[row-1][col]=true;
				visit[row][col+1]=true;
				dfs(idx+1,sum+map[row-1][col]+map[row][col+1]+(2*map[row][col]));
				visit[row][col]=false;
				visit[row-1][col]=false;
				visit[row][col+1]=false;
			}
			if(row-1>=0 && col-1>=0 && !visit[row-1][col] && !visit[row][col-1]) {
				visit[row][col]=true;
				visit[row-1][col]=true;
				visit[row][col-1]=true;
				dfs(idx+1,sum+map[row-1][col]+map[row][col-1]+(2*map[row][col]));
				visit[row][col]=false;
				visit[row-1][col]=false;
				visit[row][col-1]=false;
			}
		}
		dfs(idx+1,sum);
	}

}
