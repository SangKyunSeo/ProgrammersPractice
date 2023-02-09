
/*
 * 부분합
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,s;
	static int number[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 1;
		int sum = number[a];
		if(sum>=s) {
			min = Math.min(min, 0);
			sum-=number[a++];
		}
		
		while(a<n) {
			sum+=number[b];
			
			if(sum>=s) {
				min = Math.min(min, Math.abs(a-b));
				if(a==n-1&&b==n-1)break;
				while(sum>=s) {
					sum-=number[a];
					a++;	
					if(a>=n)break;
					if(sum>=s) {
						min = Math.min(min, Math.abs(a-b));
					}
					
				}
			}
			if(sum<s){
				if(b+1<n)b++;
				else break;
			}
		}
		if(min==Integer.MAX_VALUE)System.out.println(0);
		else System.out.println(min+1);
	}

}

