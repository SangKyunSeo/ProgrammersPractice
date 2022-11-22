/*
 * 두 동전
 */
import java.util.*;
import java.io.*;

class coins{
	int x1,x2,y1,y2;
	coins(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
public class Main {
	static int n,m;
	static String[][] map;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int x1,x2,y1,y2;
	static int first = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		
		for(int i=0;i<n;i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = Character.toString(arr[j]);
				if(map[i][j].equals("o")) {
					first++;
					if(first==1) {
						x1=i;
						y1=j;	
					}else{
						x2=i;
						y2=j;
					}
				}
			}
			
		}
	
		solve(new coins(x1,y1,x2,y2),1);
		
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	public static void solve(coins coin, int depth) {
		if(depth>10||depth==Integer.MAX_VALUE) {
			return;
		}
		
		for(int i=0;i<4;i++) {
			int twoOut = 0;
			int nx1 = coin.x1 + dx[i];
			int ny1 = coin.y1 + dy[i];
			int nx2 = coin.x2 + dx[i];
			int ny2 = coin.y2 + dy[i];
			
			if(nx1<0||ny1<0||nx1>=n||ny1>=m)twoOut++;
			if(nx2<0||ny2<0||nx2>=n||ny2>=m)twoOut++;
			
			if(twoOut==2) {
				continue;
			}
			
			if(twoOut==1) {
				min = Math.min(min, depth);	
				return;
			}
			
			if(map[nx1][ny1].equals("#")) {
				nx1 = coin.x1;
				ny1 = coin.y1;
			}
			if(map[nx2][ny2].equals("#")) {
				nx2 = coin.x2;
				ny2 = coin.y2;
			}
			
			solve(new coins(nx1,ny1,nx2,ny2),depth+1);
			
		}
	}
}