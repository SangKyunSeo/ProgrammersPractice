
/*
 * 전구와 스위치
 */
import java.util.*;
import java.io.*;
public class Main {

	static int n;
	static boolean givenA[];
	static boolean givenB[];
	static boolean goal[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char a[] = br.readLine().toCharArray();
		char b[] = br.readLine().toCharArray();
		givenA = new boolean[a.length];
		givenB = new boolean[a.length];
		goal = new boolean[b.length];
		
		for(int i=0;i<givenA.length;i++) {
			if(a[i]=='0') {
				givenA[i]=false;
				givenB[i]=false;
			}
			else {
				givenA[i]=true;
				givenB[i]=true;
			}
			
			if(b[i]=='0')goal[i]=false;
			else goal[i]=true;
		}
		
		search(1,0,givenA);
		search(1,1,switching(0,givenB));
		
		if(min == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	public static boolean[] switching(int index,boolean[] arr) {
		for(int i=index-1;i<=index+1;i++) {
			if(i>=0&&i<n) {
				arr[i]=!arr[i];
			}
		}
		return arr;
	}
	public static void search(int index, int count, boolean[] arr) {
		if(index==n) {
			if(arr[index-1]==goal[index-1]) {
				min = Math.min(min, count);
			}
			return;
		}
		
		if(goal[index-1]==arr[index-1]) {
			search(index+1,count,arr);
		}else {
			search(index+1,count+1,switching(index,arr));
		}
	}

}
