
/*
 * 친구 팰린드롬
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int[][] friends;
	static boolean visit[];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		friends = new int[m][2];
		visit = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				friends[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		max*=2;
		if(max<n) 
			max++;
		
		System.out.println(max);
	}
	public static void dfs(int depth,int count) {
		if(depth==m) {
			max = Math.max(max, count);
			return;
		}
		
		if(visit[friends[depth][0]]||visit[friends[depth][1]]) {
			dfs(depth+1,count);
		}else {
			visit[friends[depth][0]]=true;
			visit[friends[depth][1]]=true;
			
			dfs(depth+1,count+1);
			
			visit[friends[depth][0]]=false;
			visit[friends[depth][1]]=false;
			
			dfs(depth+1,count);
			
		}
		
	}

}
