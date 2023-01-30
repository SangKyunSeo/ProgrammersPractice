
/*
 * n과m 12
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static Set<Integer> set = new HashSet<>();
	static int num[];
	static int result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		result = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		num = new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		
		for(int i=0;i<num.length;i++) {
			num[i]=iter.next();
		}
		Arrays.sort(num);
		
		dfs(0);

	}
	public static void dfs(int depth) {
		if(depth==m) {
			if(check())
				print();
			return;
		}
		
		for(int i=0;i<num.length;i++) {
			result[depth]=num[i];
			dfs(depth+1);
		}
	}
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.toString());
	}
	public static boolean check() {
		Stack<Integer> s = new Stack<>();
		s.add(result[0]);
		for(int i=1;i<result.length;i++) {
			if(s.peek()<=result[i])s.add(result[i]);
		}
		
		if(s.size()==result.length)return true;
		else return false;
		
	}

}
