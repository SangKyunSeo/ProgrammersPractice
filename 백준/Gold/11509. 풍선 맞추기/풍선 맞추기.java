
/*
 * 풍선 맞추기
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] ballon;
	static int[] arrow = new int[1000001];
	static int count = 0;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		ballon = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			ballon[i]=Integer.parseInt(st.nextToken());
			max = Math.max(max, ballon[i]);
		}
		arrow[ballon[0]]=1;
		for(int i=0;i<n;i++) {
			if(arrow[ballon[i]]!=0) {
				arrow[ballon[i]]-=1;
				arrow[ballon[i]-1]+=1;
			}else {
				arrow[ballon[i]-1]+=1;
			}
		}
		
		for(int i=0;i<max;i++) {
			count+=arrow[i];
		}
		System.out.println(count);
		
		
	}

}
