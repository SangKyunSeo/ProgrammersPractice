
/*
 * 숫자 고르기
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int match[];
	static boolean visit[];
	static List<Integer> result = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		match = new int[n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++) {
			match[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i,i);
				visit[i] = false;
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
	
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
	public static void dfs(int start,int target) {
		
		if(match[start]==target+1) {
			result.add(target+1);
		}
		
		if(!visit[match[start]-1]) {
			visit[match[start]-1]=true;
			dfs(match[start]-1,target);
			visit[match[start]-1]=false;
		}
		
		
		
	}

}
