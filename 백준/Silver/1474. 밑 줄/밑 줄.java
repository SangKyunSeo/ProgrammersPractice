
/*
 * 밑줄
 */
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static String[] word;
	static int wordLength = 0;
	static int underBar[];
	static int count = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		word = new String[n];
		underBar = new int[n-1];
		
		for(int i=0;i<n;i++) {
			word[i] = br.readLine();
			wordLength+=word[i].length();
		}
		
		count = m - wordLength;
		
		while(count>0) {
			for(int i=0;i<underBar.length;i++) {
				underBar[i]+=1;
				count--;
				if(count==0)break;
			}
		}
		
		for(int i=0;i<underBar.length;i++) {
			max = Math.max(max,underBar[i]);
			min = Math.min(min, underBar[i]);
		}
		sb.append(word[0]);
		for(int i=1;i<word.length;i++) {
			if(word[i].charAt(0)>='A'&&word[i].charAt(0)<='Z') {
				if(find(min))plus(min);
				else plus(max);
			}else {
				if(find(max))plus(max);
				else plus(min);
			}
			sb.append(word[i]);
		}
		
		System.out.println(sb.toString());
	}
	public static boolean find(int num) {
		for(int i=0;i<underBar.length;i++) {
			if(underBar[i]==num) return true;
		}
		return false;
	}
	public static void plus(int num) {
		for(int i=0;i<num;i++) {
			sb.append("_");
		}
		for(int i=0;i<underBar.length;i++) {
			if(underBar[i]==num) {
				underBar[i]=-1;break;
			}
		}
	}

}
