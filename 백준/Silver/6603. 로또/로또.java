
/*
 * 로또 - 브루트포스
 */
import java.util.*;
import java.io.*;

public class Main {
	static int k = 0;
	static List<Integer> list;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0)break;
			
			visit = new boolean[k];
			
			for(int i=0;i<k;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			dfs(0,0);
			System.out.println();
		}
		
	}
	public static void dfs(int depth, int start) {
		
		if(depth==6) {
			sb = new StringBuilder();
			for(int i=0;i<k;i++) {
				if(visit[i]) {
					sb.append(list.get(i));
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
		}
		
		for(int i=start;i<k;i++) {
			visit[i]=true;
			dfs(depth+1,i+1);
			visit[i]=false;
		}
	}

}
