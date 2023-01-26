
/*
 * 최소비용 구하기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int start,end;
	static int map[][];
	static boolean visit[];
	static int d[];
	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		d = new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				map[i][j]=INF;
			}
			d[i]=INF;
		}
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(map[a][b]!=INF) {
				map[a][b]=Math.min(map[a][b], c);
			}else {
				map[a][b]=c;			
			}
	
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		d[start]=0;
		visit[start]=true;
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				if(map[start][i]!=INF) {
					d[i]=map[start][i];
				}
			}
		}
		
		for(int i=0;i<n-1;i++) {
			int min = Integer.MAX_VALUE;
			int minidx=start;
			
			for(int j=1;j<n+1;j++) {
				if(!visit[j]) {
					if(min>d[j]) {
						minidx=j;
						min=d[j];
					}
				}
			}
			
			visit[minidx]=true;
			
			for(int j=1;j<n+1;j++) {
				if(!visit[j]) {
					if(map[minidx][j]!=INF) {
						if(d[j]>map[minidx][j]+d[minidx]) {
							d[j]=map[minidx][j]+d[minidx];
						}
					}
				}
			}
		}
		
		System.out.println(d[end]);

	}

}
