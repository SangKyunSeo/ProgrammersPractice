
/*
 * 연산자 끼워넣기 - 브루트포스 , 백트래킹
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n = 0;
	static int[] op = new int[4];
	static int[] number;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			number[i] = Integer.parseInt(st.nextToken().toString());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken().toString());
		}
		
		dfs(number[0],1);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
	}
	public static void dfs(int num, int depth) {
		if(depth==n) {
			list.add(num);
		}
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				op[i]--;
				if(i==0)dfs(num + number[depth],depth+1);
				else if(i==1)dfs(num - number[depth],depth+1);
				else if(i==2)dfs(num * number[depth],depth+1);
				else dfs(num / number[depth],depth+1);
				op[i]++;
			}
		}
	}

}
