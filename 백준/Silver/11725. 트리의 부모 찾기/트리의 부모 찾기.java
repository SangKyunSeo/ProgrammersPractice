
/*
 * tree의 부모 찾기
 */
import java.util.*;
import java.io.*;


public class Main {
	static List<Integer> list[];
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[n+1];
		parents = new int[n+1];
		
		for(int i =0;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0;i<n-1;i++) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 list[a].add(b);
			 list[b].add(a);
		}
		
		dfs(list,parents,1,0);
		
		for(int j=2;j<n+1;j++)System.out.println(parents[j]);
	}
	public static void dfs(List<Integer> list[], int[] parents,int start,int parent) {
		parents[start]=parent;
		for(int i:list[start]) {
			if(i!=parent)dfs(list,parents,i,start);
		}
	}

}
