/*
 * 선발 명단
 */
import java.util.*;
import java.io.*;

public class Main {

	static int c;
	static int map[][] = new int[11][11];
	static boolean visit[] = new boolean[11];
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(c>0) {
			for(int i=0;i<11;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<11;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			System.out.println(result);
			c--;
			init();
		}

	}
	public static void dfs(int row,int sum) {
		if(row==11) {
			result = Math.max(sum,result);
		}
		
		for(int i=0;i<11;i++) {
			if(!visit[i] && map[row][i]!=0) {
				visit[i]=true;
				dfs(row+1,sum+map[row][i]);
				visit[i]=false;
			}
		}
	}
	public static void init() {
		Arrays.fill(visit, false);
		result = Integer.MIN_VALUE;
	}

}
