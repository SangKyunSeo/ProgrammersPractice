
/*
 * 치즈 - bfs dfs
 */

import java.util.*;
import java.io.*;

class point{
	int x,y;
	point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count = 0;
	static List<Integer> list = new ArrayList<>();
	static int hour = 0;
	static boolean check = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			count = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==1) {
						count++;
					}
				}
			}
			
			check=false;
			bfs();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(visit[i][j]) {
						visit[i][j]=false;
					}
					
				}
			}
			
			if(count>0) {
				list.add(count);
			}
			
			if(check==false)
				break;
			
			hour++;
			
		}
		Collections.sort(list);
		System.out.println(hour);
		if(list.size()!=0) {
			System.out.println(list.get(0));
		}
		else
			System.out.println(0);
		
		
		
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(0,0));
		visit[0][0]=true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visit[nx][ny]&&map[nx][ny]==0) {
						visit[nx][ny]=true;
						q.offer(new point(nx,ny));
					}
					else if(!visit[nx][ny]&&map[nx][ny]==1) {
						check=true;
						map[nx][ny] = 0;
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		
	}

}
