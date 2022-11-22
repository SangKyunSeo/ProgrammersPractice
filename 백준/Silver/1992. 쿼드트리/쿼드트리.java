import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean allzero = false;
	static boolean allone = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = Character.getNumericValue(arr[j]);
			}
		}
		divide(0,0,n);
	}
	
	public static void divide(int x, int y, int size) {
		if(isPossible(x,y,size)) {
			System.out.print(map[x][y]);
			return;
		}
		
		int newSize = size/2;
		
		System.out.print("(");
		
		divide(x,y,newSize);
		divide(x,y+newSize,newSize);
		divide(x+newSize,y,newSize);
		divide(x+newSize,y+newSize,newSize);
		
		System.out.print(")");
	}
	
	public static boolean isPossible(int x,int y,int size) {
		int val = map[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(val!=map[i][j])
					return false;
			}
		}
		return true;
	}
}