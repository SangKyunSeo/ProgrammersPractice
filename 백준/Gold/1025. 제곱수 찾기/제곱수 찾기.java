
/*
 * 제곱수 찾기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int map[][];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				solve(i,j);
			}
		}
		
		if(max==Integer.MIN_VALUE)System.out.println(-1);
		else System.out.println(max);
	}
	public static void solve(int x,int y) {
		for(int i=-n;i<n;i++) {
			for(int j=-m;j<m;j++) {
				int nx = x;
				int ny = y;
				int sqr = 0;
				
				if(i==0&&j==0)continue;
				
				while(nx>=0&&ny>=0&&nx<n&&ny<m) {
					sqr *= 10;
					sqr += map[nx][ny];
					int root = (int)Math.sqrt(sqr);
					if(Math.pow(root, 2)==sqr)max = Math.max(sqr, max);
					
					nx+=i;
					ny+=j;
				}
			}
		}
	}

}
