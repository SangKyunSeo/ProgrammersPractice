
/*
 * 인구 이동
 */
import java.util.*;
import java.io.*;
class point{
	int x,y;
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int n,l,r;
	static int[][] map;
	static boolean[][] visit;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int sum = 0;
	static int count = 0;
	static Queue<point> linkCountry = new LinkedList<>();
	static boolean check = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//연합 찾기
	
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j]) {
					bfs(i,j);
					if(check) {
						
						if(visitCheck()) {
							initvisit();
							i=0;
							j=-1;
						}
					}
						
				}
					
			}
		}
		
		
		System.out.println(count);
		
	}
	public static void initvisit() {
		count++;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				visit[i][j]=false;
			}
		}
		check=false;
	}
	public static boolean visitCheck() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==false)return false;
			}
		}
		return true;
	}
	public static void bfs(int x,int y) {
		Queue<point> q = new LinkedList<>();
		sum = map[x][y];
		q.offer(new point(x,y));
		visit[x][y]=true;
		linkCountry.offer(new point(x,y));
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(!visit[nx][ny]&&Math.abs(map[p.x][p.y]-map[nx][ny])>=l&&Math.abs(map[p.x][p.y]-map[nx][ny])<=r) {
						linkCountry.offer(new point(nx,ny));
						visit[nx][ny]=true;
						q.offer(new point(nx,ny));
						sum+=map[nx][ny];
					}
				}
			}
		}
		//linkCountry에는 조건을 만족하는 이웃 나라의 좌표가 들어있을 것.
		if(linkCountry.size()>1) {
			check=true;
			int val = sum/linkCountry.size();
			while(!linkCountry.isEmpty()) {
				point p = linkCountry.poll();
				map[p.x][p.y]=val;
			}
			sum=0;
		}else {
			linkCountry.clear();
			sum=0;
		}
		
	}

}
