
/*
 * 행렬
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int[][] a;
	static int[][] b;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		b = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				a[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				b[i][j] = Character.getNumericValue(s.charAt(j)); 
			}
		}
		
		if(n<3||m<3) {
			if(check())System.out.println(0);
			else System.out.println(-1);
			return;
		}
		for(int i=0;i<=n-3;i++) {
			for(int j=0;j<=m-3;j++) {
				if(a[i][j]!=b[i][j])flip(i,j);
				if(check()) {
					System.out.println(count);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	public static void flip(int x,int y) {
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				if(a[i][j]==1)a[i][j]=0;
				else a[i][j]=1;
			}
		}
		
		count++;
	}
	public static boolean check() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]!=b[i][j])return false;
			}
		}
		return true;
	}

}
