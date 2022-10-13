
/*
 * 트리의 지름
 */
import java.io.*;
import java.util.*;

class Node{
	int edge;
	int cost;
	public Node(int edge,int cost) {
		this.edge = edge;
		this.cost = cost;
	}
}
public class Main {
	static List<Node> list[];
	static boolean[] visit;
	static int max =0;
	static int node;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		list = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(true) {
				int b = Integer.parseInt(st.nextToken());
				if(b==-1)break;
				int cost = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,cost));
			}
		}
		
		dfs(1,0);
		visit = new boolean[n+1];
		dfs(node,0);
		System.out.println(max);
		
	}
	public static void dfs(int x, int len) {
		if(len>max) {
			max = len;
			node = x;
		}
		visit[x]=true;
		for(int i=0;i<list[x].size();i++) {
			Node k = list[x].get(i);
			if(!visit[k.edge]) {
				dfs(k.edge,k.cost+len);
				visit[k.edge]=true;
			}
		}
	}
	
	
}
