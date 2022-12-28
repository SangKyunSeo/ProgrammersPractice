
/*
 * 트리 순회
 */
import java.util.*;
import java.io.*;
class node{
	int right;
	int left;
	public node(int left,int right) {
		
		this.left = left;
		this.right = right;
	}
}
public class Main {

	static int n;
	static int count = 0;
	static List<node>[] list;
	static List<Integer> inOrder = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			list[value].add(new node(left,right));
		}
		
		dfs(1,0,true);
		dfs(1,0,false);

	}
	public static void dfs(int cur,int parent,boolean flag) {
		for(node n:list[cur]) {
			if(n.left!=-1) {
				dfs(n.left,cur,flag);
				if(!flag)count++;
			}
			if(flag) {
				inOrder.add(cur);
			}else {
				if(inOrder.get(inOrder.size()-1)==cur) {
					System.out.println(count);
					return;
				}
				count++;
			}
			
			if(n.right!=-1) {
				dfs(n.right,cur,flag);
				if(!flag)count++;
			}
			
			
		}
	}

}
