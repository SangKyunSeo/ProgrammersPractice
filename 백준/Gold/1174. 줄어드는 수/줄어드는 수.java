

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<Long> list = new ArrayList<>();
	static int array[] = {9,8,7,6,5,4,3,2,1,0};
	static boolean visit[] = new boolean[10];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dfs(0);
		Collections.sort(list);
		if(list.size()<n)
			System.out.println(-1);
		else
			System.out.println(list.get(n-1));
	}
	public static void dfs(int depth) {
		if(depth==10) {
			return;
		}
		
		for(int i=depth;i<10;i++) {
			if(!visit[i]) {
				visit[i]=true;
				plus();
				dfs(i+1);
				visit[i]=false;
			}
		}
	}
	public static void plus() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<visit.length;i++) {
			if(visit[i]) {
				sb.append(array[i]);
			}
		}
		
		list.add(Long.parseLong(sb.toString()));
	}

}
