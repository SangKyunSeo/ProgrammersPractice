
/*
 * ZOAC
 */
import java.io.*;
import java.util.*;

public class Main {

	static String s;
	static char[] word;
	static char min;
	static boolean check[];
	static int size;
	static int index = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		word = s.toCharArray();
		size = s.length();
		check = new boolean[size];
		
		solve(0,size);
	}
	public static void solve(int left, int right) {
		if(left>right-1)return;
		
		int index = left;
		char min = word[index];
		for(int i=left;i<right;i++) {
			if(min>word[i]) {
				min = word[i];
				index = i;
			}
		}
		check[index]=true;
		print(index);
		solve(index+1,right);
		solve(left,index);
	}
	public static void print(int index) {
		for(int i=0;i<check.length;i++) {
			if(check[i])System.out.print(word[i]);
		}
		System.out.println();
	}

}
