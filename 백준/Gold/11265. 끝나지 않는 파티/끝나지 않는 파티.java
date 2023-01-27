
/*
 * 끝나지 않는 파티
 */
import java.util.*;
import java.io.*;

public class Main {

	final static long INF = Long.MAX_VALUE;
	static int n,m;
	static int map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long time = Long.parseLong(st.nextToken());
			
			solve(start,end,time);
		}
	}
	public static void solve(int start, int end, long time) {
		long d[] = new long[n];
		boolean visit[] = new boolean[n];
		
		for(int i=0;i<n;i++) {
			d[i]=INF;
		}
		
		d[start-1]=0;
		visit[start-1]=true;
		
		for(int i=0;i<n;i++) {
			if(!visit[i] && map[start-1][i]!=0) {
				d[i]=map[start-1][i];
			}
		}
		
		for(int i=0;i<n-1;i++) {
			long min = Long.MAX_VALUE;
			int minIdx = -1;
			
			for(int j=0;j<n;j++) {
				if(!visit[j]) {
					if(min>d[j]) {
						min = d[j];
						minIdx=j;
					}
				}
			}
			visit[minIdx]=true;
			
			for(int j=0;j<n;j++) {
				if(!visit[j]) {
					if(d[j]>d[minIdx] + map[minIdx][j]) {
						d[j]=d[minIdx] + map[minIdx][j]; 
					}
				}
			}
		}
		
		if(d[end-1]>time)System.out.println("Stay here");
		else System.out.println("Enjoy other party");
		
	}

}
