
/*
 * 불!
 */
import java.util.*;
import java.io.*;

class point{
	int x,y,depth;
	boolean human;
	point(int x,int y,int depth,boolean human){
		this.x=x;
		this.y=y;
		this.depth=depth;
		this.human=human;
	}
}
public class Main {

	static int r,c;
	static char[][] map;
	static char[][] copy;
	static boolean[][] visit;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static boolean check = false;
	static Queue<point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		copy = new char[r][c];
		visit = new boolean[r][c];
		for(int i=0;i<r;i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j] = arr[j];
				copy[i][j] = map[i][j];
			}
		}
		
		init();
		bfs();
		if(min==Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		}else System.out.println(min+1);
		
	}
	public static void init() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='F') {
					q.offer(new point(i,j,0,false));
					visit[i][j]=true;
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='J') {
					q.offer(new point(i,j,0,true));
					visit[i][j]=true;
				}
			}
		}
		
		
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0||ny<0||nx>=r||ny>=c) {
					if(p.human) {
						min = Math.min(min, p.depth);
					}
				}
				if(nx>=0&&ny>=0&&nx<r&&ny<c) {
					if(p.human&&!visit[nx][ny]&&map[nx][ny]!='#'&&map[nx][ny]!='F') {
						visit[nx][ny]=true;
						map[nx][ny]=map[p.x][p.y];
						q.offer(new point(nx,ny,p.depth+1,true));
					}else if(!p.human&&!visit[nx][ny]&&map[nx][ny]!='#') {
						visit[nx][ny]=true;
						map[nx][ny]=map[p.x][p.y];
						q.offer(new point(nx,ny,0,false));
					}
				}
			}
		}
	}
	
}


