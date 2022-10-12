
import java.util.*;
import java.io.*;

class Node{
	int left;
	int right;
	public Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class Main {
	static List<Node>[] list;
	static List<Integer>[] chart;
	static int count = 1;
	static int row = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		chart = new ArrayList[n+1];
		for(int i =1;i<n+1;i++) {
			list[i]=new ArrayList<>();
			chart[i]=new ArrayList<>();
		}
		
		
		int[] check = new int[n+1];
		int root=-1;
		for(int i =0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if(left!=-1)check[left]++;
			if(right!=-1)check[right]++;
			list[start].add(new Node(left,right));
		}
		
		for(int i =1;i<n+1;i++) {
			if(check[i]==0) {
				root=i;break;
			}
		}
		
		inOrder(root);
		int max = -1;
		int level = 0;
		for(int i=1;i<n+1;i++) {
			int len = chart[i].size();
			if(len>0) {
				int s = chart[i].get(0);
				int e = chart[i].get(len-1);
				int w = e-s+1;
				
				if(max<w) {
					max = w;
					level=i;
				}
			}
		}
		System.out.println(level + " " +max);
	}
	
		 static void inOrder(int node) {
			for(Node n:list[node]) {
				if(n.left!=-1) {
					count++;
					inOrder(n.left);
				}
				row++;
				chart[count].add(row);
				if(n.right!=-1) {
					count++;
					inOrder(n.right);
					
				}
				count--;
				}
			}
}
