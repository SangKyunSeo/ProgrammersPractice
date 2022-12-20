
/*
 * 배열 돌리기 1
 */
import java.io.*;
import java.util.*;
public class Main {
	static int n,m,r,count;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		count = Math.min(n, m)/2;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<count;j++) {
				move(j,m-j,n-j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void move(int x,int w,int h) {
		int tmp = map[x][x];
		left(x,w,h);
		up(x,w,h);
		right(x,w,h);
		down(x,w,h);
		map[x+1][x]=tmp;
	}
	public static void left(int x,int w,int h) {
		for(int i=x;i<w-1;i++) {
			map[x][i]=map[x][i+1];
		}
	}
	public static void up(int x,int w,int h) {
		for(int i=x;i<h-1;i++) {
			map[i][w-1]=map[i+1][w-1];
		}
	}
	public static void right(int x,int w,int h) {
		for(int i=w-1;i>x;i--) {
			map[h-1][i]=map[h-1][i-1];
		}
	}
	public static void down(int x,int w,int h) {
		for(int i=h-1;i>x;i--) {
			map[i][x]=map[i-1][x];
		}
	}

}
