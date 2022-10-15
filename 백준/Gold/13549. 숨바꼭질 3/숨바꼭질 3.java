
/*
 * 숨바꼭질3
 */

import java.io.*;
import java.util.*;

public class Main {
	static int max = 100000;
	static boolean visit[] = new boolean[max+1];
	static int min = Integer.MAX_VALUE;
	static int n,k;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs(n);
		System.out.println(min);
	}
	public static void bfs(int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			visit[node.x]=true;
			if(node.x==k)min=Math.min(min, node.time);
			if(node.x*2<=max&&!visit[node.x*2])q.offer(new Node(node.x*2,node.time));
			if(node.x+1<=max&&!visit[node.x+1])q.offer(new Node(node.x+1,node.time+1));
			if(node.x-1>=0&&!visit[node.x-1])q.offer(new Node(node.x-1,node.time+1));
		}
	}
	static class Node{
		int x;
		int time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

}
