
/*
 * A->B
 */

import java.util.*;
import java.io.*;

public class Main {
	static int start, end;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		solve(end,0);
	
	}
	public static void solve(int end,int depth) {
		if(end<start) {
			System.out.println(-1);
			return;
		}
		if(end==start) {
			System.out.println(depth+1);
			return;
		}
		
		String s = Integer.toString(end);
		if(s.charAt(s.length()-1)=='1') {
			solve(Integer.parseInt(s.substring(0,s.length()-1)),depth+1);
		}else if(end%2==0) {
			solve(end/2,depth+1);
		}else {
			System.out.println(-1);
			return;
		}
			
	}

}
