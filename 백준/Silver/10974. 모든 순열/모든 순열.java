/*
 * 모든 순열
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visit = new boolean[n];
		dfs(0);
	}
	public static void dfs(int depth) {
		if(depth == n) {
			for(int i=0;i<n;i++) {
				if(visit[i]) {
					System.out.print(arr[i] + " ");
				}
				
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i-1]) {
				visit[i-1]=true;
				arr[depth] = i;
				dfs(depth+1);
				visit[i-1]=false;
			}
			
		}
	}

}
