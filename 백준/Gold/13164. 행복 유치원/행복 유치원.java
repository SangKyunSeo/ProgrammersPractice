
/*
 * 행복 유치원
 */
import java.io.*;
import java.util.*;
public class Main {

	static int n,k;
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	static int result = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n-1;i++) {
			list.add(arr[i+1]-arr[i]);
		}
		
		Collections.sort(list);
		
		for(int i=0;i<n-k;i++) {
			result+=list.get(i);
		}
		System.out.println(result);
	}

}
