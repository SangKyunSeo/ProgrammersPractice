
/*
 * 빗물
 */
import java.io.*;
import java.util.*;

public class Main {
	static int h,w;
	static int[] block;
	static int leftMax = 0;
	static int rightMax = 0;
	static int rain = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		block = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			block[i]=Integer.parseInt(st.nextToken());
		}
		
		if(w<=2)System.out.println(0);
		else {
			for(int i=1;i<w-1;i++) {
				leftMax=0;
				rightMax=0;
				if(possible(i)) {
					calAmount(i);
				}
			}	
		}
		System.out.println(rain);
	}
	public static boolean possible(int x) {
		findLeftMax(x);
		findRightMax(x);
		if(leftMax>block[x]&&rightMax>block[x])return true;
		else return false;
		
	}
	public static void findLeftMax(int x) {
		for(int i=0;i<x;i++) {
			if(block[i]>leftMax)leftMax=block[i];
		}
	}
	public static void findRightMax(int x) {
		for(int i=x+1;i<w;i++) {
			if(block[i]>rightMax)rightMax=block[i];
		}
	}
	public static void calAmount(int x) {
		int min = Math.min(leftMax, rightMax);
		rain+=min - block[x];
	}

}
