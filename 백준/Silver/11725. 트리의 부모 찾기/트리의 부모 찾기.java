
/*
 * 트리의 부모 찾기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<Integer> list[];
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		parent = new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<>(); 
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		for(int i=2;i<parent.length;i++) {
			System.out.println(parent[i]);
		}
		
	}
	public static void dfs(int p) {
		for(int i : list[p]) {
			if(parent[i]==0) {
				parent[i]=p;
				dfs(i);
			}
		}
	}

}
