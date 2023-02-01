
/*
 * 줄어드는 수
 */
import java.io.*;
import java.util.*;

public class Main {

	static int num[] = {9,8,7,6,5,4,3,2,1,0};
	static List<Long> list = new ArrayList<>();
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dfs(0,0);
		Collections.sort(list);
		if(n>1023) {
			System.out.println(-1);
		}else {
			System.out.println(list.get(n-1));
		}
	}
	public static void dfs(long sum,int idx) {
		if(!list.contains(sum))list.add(sum);
		
		if(idx>=10) {
			return;
		}
		
		dfs(sum*10 + num[idx],idx+1);
		dfs(sum,idx+1);
	}

}
