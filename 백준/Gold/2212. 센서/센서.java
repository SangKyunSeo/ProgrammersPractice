
/*
 * 센서
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n,k;
	static int arr[];
	static int dist[];
	static int result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		dist = new int[n-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<n-1;i++) {
			dist[i]=Math.abs(arr[i]-arr[i+1]);
		}
		
		Arrays.sort(dist);
		
		for(int i=0;i<n-k;i++) {
			result+=dist[i];
		}
		System.out.println(result);
	}

}
