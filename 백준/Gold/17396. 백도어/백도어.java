
/*
 * 백도어
 */

import java.util.*;
import java.io.*;


public class Main {

	final static long INF = Long.MAX_VALUE;
	static int n,m;
	static int visible[];
	static List<node> list[];
	static boolean visit[];
	static long d[];
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visible = new int[n];
		list = new ArrayList[n];
		visit = new boolean[n];
		d = new long[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			visible[i]=Integer.parseInt(st.nextToken());
			if(visible[i]==1)count++;
		}
		visible[n-1]=0;
		count--;
		for(int i=0;i<n;i++) {
			d[i]=INF;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new node(b,c));
			list[b].add(new node(a,c));
		}
		
		// 초기 값 설정
		d[0]=0;
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.offer(new node(0,0));
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			
			if(visit[cur.node])continue;
			visit[cur.node]=true;
			
			for(int i=0;i<list[cur.node].size();i++) {
				node next = list[cur.node].get(i);
				if(next.node != n-1 && visible[next.node]==1)continue;
				if(d[next.node]>d[cur.node] + next.cost) {
					d[next.node] = d[cur.node] + next.cost;
					pq.offer(new node(next.node,d[next.node]));
				}
			}
		}
		
		if(d[n-1]==INF)System.out.println(-1);
		else System.out.println(d[n-1]);

	}
	public static class node implements Comparable<node>{
		int node;
		long cost;
		
		public node(int node, long cost) {
			this.node = node;
			this.cost = cost;
		}
		
		public int compareTo(node n) {
			if(this.cost -n.cost>0)return 1;
			else return -1;
		}
	}

}
