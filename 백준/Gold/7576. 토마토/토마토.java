
/*
 * 토마토
 */
import java.util.*;
import java.io.*;

class point{
	int x,y,cnt;
	point(int x,int y,int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static Queue<point> q = new LinkedList<>();
	static boolean check=true;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n+1][m+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]==1) {
					q.offer(new point(i,j,0));
				}
			}
		}
		
		boolean ck = true;
		if(q.size()==0) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					if(map[i][j]==0) {
						ck = false;
					}
				}
			}
			if(!ck)System.out.println("-1");
			else
				System.out.println("0");
		}
		else bfs();
		
	}
	public static void bfs() {
		boolean check = true;
		while(!q.isEmpty()) {
			point p = q.poll();
			visit[p.x][p.y]=true;
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visit[nx][ny]&&map[nx][ny]==0) {
						map[nx][ny]=1;
						q.offer(new point(nx,ny,p.cnt+1));
					}
				}
			}
			
			if(q.isEmpty())answer = p.cnt;
		}
		for(int i =0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]==0)check = false;
			}
		}
		if(check)System.out.println(answer);
		else System.out.println("-1");
	}

}
