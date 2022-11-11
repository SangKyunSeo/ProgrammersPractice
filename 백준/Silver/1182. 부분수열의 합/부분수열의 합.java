

import java.io.*;
import java.util.*;

public class Main {
	static int n = 0;
	static int s = 0;
	static List<Integer> list = new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0,0);
		
		if(s==0)count--;
		System.out.println(count);
	}
	public static void dfs(int index, int sum) {
		if(index==n) {
			if(sum==s) {
				count++;
			}
			return;
		}
		
		dfs(index+1,sum+list.get(index));
		dfs(index+1,sum);
	}

}
