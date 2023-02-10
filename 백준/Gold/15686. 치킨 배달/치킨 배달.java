
/*
 * 치킨 배달
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int map[][];
	static int chickens[][];
	static int count = 0;
	static int homeCount = 0;
	static boolean visit[];
	static int result = 0;
	static int resultMin = Integer.MAX_VALUE;
	static int home[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)homeCount++;
				if(map[i][j]==2)count++;
			}
		}
		visit = new boolean[count];
		chickens = new int[count][2];
		home = new int[homeCount][2];
		
		find();
		
		dfs(0,0);
		System.out.println(resultMin);
	}
	public static void find() {
		int idx = 0;
		int hIdx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					home[hIdx][0]=i;
					home[hIdx][1]=j;
					hIdx++;
				}
				if(map[i][j]==2) {
					chickens[idx][0]=i;
					chickens[idx][1]=j;
					idx++;
				}
			}
		}
	}
	public static void dfs(int start,int depth) {
		if(depth==m) {
			result = 0;
			for(int i=0;i<home.length;i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<visit.length;j++) {
					if(visit[j]) {
						min = Math.min(min, Math.abs(home[i][0] - chickens[j][0]) + Math.abs(home[i][1] - chickens[j][1]));
					}
				}
				result+=min;
			}
			resultMin = Math.min(result, resultMin);
			return;
		}
		
		for(int i=start;i<count;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(i+1,depth+1);
				visit[i]=false;
			}
		}
	}

}
