
/*
 * 직사각형 탈출
 */
import java.util.*;
import java.io.*;
class point{
	int x,y,depth;
	point(int x,int y,int depth){
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
public class Main {

	static int n,m;
	static int h,w,sr,sc,fr,fc;
	static int map[][];
	static int wall[][];
	static int index = 1;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Queue<point> q = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	static boolean visit[][];
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)count++;
			}
		}
		
		wall = new int[count][2];
		int idx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					wall[idx][0]=i;
					wall[idx][1]=j;
					idx++;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());
		sr--;
		sc--;
		fr--;
		fc--;
		
		bfs();
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void bfs() {
		q.offer(new point(sr,sc,0));
		visit[sr][sc]=true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x==fr&&p.y==fc) {
				min = Math.min(min, p.depth);
			}
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(mapCheck(nx,ny)) {
					if(check(nx,ny)) {
						if(!visit[nx][ny]) {
							q.offer(new point(nx,ny,p.depth+1));
							visit[nx][ny]=true;
						}
					}
				}
			}
		}
	}
	public static boolean check(int x,int y) {
		for(int i=0;i<wall.length;i++) {
			if(wall[i][0]>=x&&wall[i][0]<=x+h-1&&wall[i][1]>=y&&wall[i][1]<=y+w-1)return false;
		}
		return true;
	}
	public static boolean mapCheck(int x,int y) {
		if(x>=0&&x+h-1<n&&y>=0&&y+w-1<m)return true;
		else return false;
	}

}


