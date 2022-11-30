
/*
 * 주유소 - greedy
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n = 0;
	static int[] fare;
	static int[] pay;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		pay = new int[n-1];
		fare = new int[n];
		long cost = 0;
		long min = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n-1;i++) {
			pay[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			fare[i]=Integer.parseInt(st.nextToken());
		}
		
		cost = fare[0];
		for(int i=0;i<n-1;i++) {
			
			if(cost>fare[i])cost = fare[i];
			
			min += cost * pay[i];
		}
		
		System.out.println(min);

	}

}
