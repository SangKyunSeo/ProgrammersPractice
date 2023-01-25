
/*
 * 경로찾기
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int map[][];
	static boolean visit[];
	static List<Integer> list[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		StringTokenizer st;
		map = new int[n][n];
		list = new ArrayList[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		makeList();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0)find(i,j);
			}
		}
		
		print();
	}
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void makeList() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					list[i].add(j);
				}
			}
		}
	}
	
	public static void find(int x,int y) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(y);
		while(!q.isEmpty()) {
			int ny = q.poll();
			for(int i:list[ny]) {
				if(!visit[i]) {
					visit[i]=true;
					q.offer(i);
					map[x][i]=1;
				}
				
			}
		}
		
		initVisit();
	}
	public static void initVisit() {
		for(int i=0;i<n;i++) visit[i]=false;
	}

}
