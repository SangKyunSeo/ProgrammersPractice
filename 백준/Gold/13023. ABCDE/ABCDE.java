
/*
 * ABCDE
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static List<Integer>[] list;
	static boolean check = false;
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		
		
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			visit = new boolean[n];		
			dfs(i,1);			
			if(check) {System.out.println(1);return;}
		}
		System.out.println(0);

	}
	public static void dfs(int idx, int depth) {
		if(depth==5) {
			check=true;
			return;
		}
		
		visit[idx]=true;
		for(int i:list[idx]) {
			if(!visit[i]) {
				dfs(i,depth+1);
			}
		}
		visit[idx]=false;
		
	}

}
