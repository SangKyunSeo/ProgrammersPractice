/*
 * 도영이가 만든 맛있는 음식
 */

import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] sour;
	static int[] bitter;
	static boolean[] sVisit;
	static boolean[] bVisit;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		sour = new int[n];
		bitter = new int[n];
		sVisit = new boolean[n];
		bVisit = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			sour[i]=Integer.parseInt(st.nextToken());
			bitter[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,1);
		System.out.println(min);
	}
	public static void dfs(int depth,int sum,int mul) {
		if(depth==n) {
			if(sum>0)
				min = Math.min(min, Math.abs(sum-mul));
			return;
		}
		
		dfs(depth+1,sum,mul);
		dfs(depth+1,sum+bitter[depth],mul*sour[depth]);
		
	}

}
