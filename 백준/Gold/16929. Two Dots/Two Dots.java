/*
 * Two Dots 
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int m;
	static char[][] map;
	static boolean visit[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int startx;
	static int starty;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit = new boolean[n][m];
				startx = i;
				starty = j;
				if(solve(i,j,1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
		
		
	}
	public static boolean solve(int x, int y, int count) {
		visit[x][y]=true;
		for(int i=0;i<4;i++) {
			int curx = x + dx[i];
			int cury = y + dy[i];
			
			if(curx>=0&&cury>=0&&curx<n&&cury<m&&map[x][y]==map[curx][cury]) {
				if(!visit[curx][cury]) {
					visit[curx][cury]=true;
					if(solve(curx,cury,count+1))return true;
				}else {
					if(count>=4&&startx==curx&&starty==cury)return true;
				}
			}
		}
		return false;
		
		
	}

}
