
/*
 * N과M 11
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int numList[];
	static int result[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m];
		Set<Integer> s = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		numList = new int[s.size()];
		Iterator<Integer> iter = s.iterator();
		
		for(int i=0;i<numList.length;i++) {
			numList[i]=iter.next();
		}
		
		dfs(0);
	}
	public static void dfs(int depth) {
		if(depth==m) {
			print();
			return;
		}
		for(int i=0;i<numList.length;i++) {
			result[depth]=numList[i];
			dfs(depth+1);
		}
	}
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<result.length;i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
