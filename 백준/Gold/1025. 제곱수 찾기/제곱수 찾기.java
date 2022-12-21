
/*
 * 제곱수 찾기
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[][] map;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j]=Character.getNumericValue(arr[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				solve(i,j);
			}
		}
		
		if(result==Integer.MIN_VALUE)System.out.println(-1);
		else System.out.println(result);

	}
	public static void solve(int i,int j) {
		for(int k=-n;k<n;k++) {
			for(int l=-m;l<m;l++) {
				
				if(k==0&&l==0)continue;
				
				int x = i;
				int y = j;
				int sqr = 0;
				while(x>=0&&y>=0&&x<n&&y<m) {
					sqr *=10;
					sqr+=map[x][y];
					
					int root = (int)Math.sqrt(sqr);
					
					if(Math.pow(root, 2)==sqr) {
						result = Math.max(result, sqr);
					}
					x+=k;
					y+=l;
				}
			}
		}
	}

}

