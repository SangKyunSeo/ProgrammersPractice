
/*
 * 벽 부수고 이동하기 
 */
import java.io.*;
import java.util.*;
class point{
	int x,y,count;
	boolean destroyed;
	
	point(int x,int y,int count,boolean destroyed){
		this.x = x;
		this.y = y;
		this.count = count;
		this.destroyed = destroyed;
	}
}
public class Main {
	
	static int n,m;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][2];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		
		bfs();
		
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else
			System.out.println(min);
		
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0,1,false));
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			if(p.x == n-1&&p.y == m-1) {
				min = Math.min(min, p.count);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(map[nx][ny]==0) {
						if(!p.destroyed&&!visit[nx][ny][0]) {
							q.add(new point(nx,ny,p.count+1,false));
							visit[nx][ny][0]=true;
						}else if(p.destroyed &&!visit[nx][ny][1]) {
							q.add(new point(nx,ny,p.count+1,true));
							visit[nx][ny][1]=true;
						}
					}else if(map[nx][ny]==1) {
						if(!p.destroyed) {
							q.add(new point(nx,ny,p.count+1,true));
							visit[nx][ny][1]=true;
						}
					}
				}
			}
			
		}
	}

}
