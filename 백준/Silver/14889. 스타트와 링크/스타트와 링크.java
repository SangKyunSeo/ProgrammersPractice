
/*
 * 스타트와 링크 백트래킹, 브루트포스
 */

import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] s;
	static int[] arr;
	static boolean[] v;
	static int s_skill = 0;
	static int l_skill = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		s = new int[n+1][n+1];
		arr = new int[n/2];
		v = new boolean[n+1];
		
		// Insert value 
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<=n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,0);
		System.out.println(min);
		
	}
	public static void dfs(int at,int depth) {
		if(depth==n/2) {
			for(int i=0;i<arr.length;i++) {
				v[arr[i]]=true;
			}
			diff();
			for(int i=0;i<arr.length;i++) {
				v[arr[i]]=false;
			}
			s_skill = 0;
			l_skill = 0;
			return;
		}
		
		for(int i=at;i<=n;i++) {
			arr[depth]=i;
			dfs(i+1,depth+1);
		}
	}
	private static void diff() {
		for(int i=1;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(v[i]==true&&v[j]==true) {
					s_skill+=s[i][j];
					s_skill+=s[j][i];
				}else if(v[i]!=true&&v[j]!=true) {
					l_skill+=s[i][j];
					l_skill+=s[j][i];
				}
			}
		}
		
		int val = Math.abs(l_skill-s_skill);
		if(val==0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(min, val);
		
	}

}
