

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int arr[];
	static int array[] = new int[2000001];
	static boolean visit[];
	static int result = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visit = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		dfs(0,0);
		
		for(int i=1;i<array.length;i++) {
			if(array[i]==0) {
				result=i;
				break;
			}
		}
		System.out.println(result);
	}
	public static void dfs(int depth,int sum) {
		if(depth==n) {
			array[sum]=1;
			return;
		}
		dfs(depth+1,sum+arr[depth]);
		dfs(depth+1,sum);
		
	}

}
