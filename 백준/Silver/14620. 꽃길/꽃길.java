
/*
 * 꽃길
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
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
		
		solve(0,0);
		System.out.println(min);
	}
	public static void solve(int depth,int sum) {
		if(depth==3) {
			min = Math.min(min, sum);
			return;
		}else {
			for(int i=1;i<n-1;i++) {
				for(int j=1;j<n-1;j++) {
					if(!visit[i][j]&&check(i,j)) {
						visit[i][j]=true;
						int flowerSum = sum(i,j);
						
						solve(depth+1,sum + flowerSum);
						
						initVisit(i,j);
					}
				}
			}
		}
	}
	public static boolean check(int x,int y) {
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(visit[nx][ny])return false;
		}
		return true;
	}
	public static int sum(int x,int y) {
		int sum = map[x][y];
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			sum+=map[nx][ny];
			visit[nx][ny]=true;
		}
		return sum;
	}
	public static void initVisit(int x,int y) {
		visit[x][y]=false;
		visit[x-1][y]=false;
		visit[x+1][y]=false;
		visit[x][y-1]=false;
		visit[x][y+1]=false;
	}
}
