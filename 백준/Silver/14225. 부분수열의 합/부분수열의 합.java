
/*
 * 부분 수열의 합 - 브루트포스
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> result = new ArrayList<>();
	static int[] arr = new int[2000001];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		dfs(0,0);
	
		Collections.sort(result);
		for(int i=0;i<result.size();i++) {
			arr[result.get(i)]=1;
		}
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==0) {
				System.out.println(i);
				break;
			}
		}
	}
	public static void dfs(int index,int sum) {
		if(index==n) {
			result.add(sum);
			return;
		}
		
		dfs(index+1,sum+list.get(index));
		dfs(index+1,sum);
	}

}
